package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

import engine.Message;
import server_gui.ServerConnectedClientsPanel;

public class ConnectionThread extends Thread {
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private boolean isAlive = false;
	
	private String clientIP = "";
	
	private Socket client;
	private String sessionID;
	
	public ConnectionThread(Socket client) {
		this.client = client;
		clientIP = client.getRemoteSocketAddress().toString();
	}
	
	private void cleanUp() {
		ServerConnectedClientsPanel.removeElementFromList(sessionID);
		TCPServer.userCount--;
		try {
			input.close();
			output.close();
			client.close();
			TCPServer.removeConnection(sessionID);
		}catch(Exception e) {
			e.printStackTrace();
		}
		serviceMessage("Thread " + client.getInetAddress() + " closed.");
	}
	
	private void serviceMessage(String message) {
		String timeStamp = "{" + new Date().toString().substring(11, 19) + "}";
		System.out.println(timeStamp+"[THREAD "+ sessionID + "]" +message);
	}
	
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		serviceMessage("Conversation IO streams created");
	}
	
	public void sendMessage(String message) {
		Message<String, Object> m = new Message<String, Object>(message);
		try {
			output.writeObject(m);
			output.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message, Object object) {
		Message<String, Object> m = new Message<String, Object>(message, object);
		try {
			output.writeObject(m);
			output.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectClient(String kickReason) { 
		if(!kickReason.equals("clientLEFT"))sendMessage("A3."+kickReason);
		isAlive = false;
		cleanUp();
	}
	
	private void greetUser() {
		String message = generateSessionID();
		if(!TCPServer.getAllConnections().containsKey(message)) {
			TCPServer.getAllConnections().put(message, this);
		} else greetUser();
		sessionID = message;
		sendMessage("A2.TRUE."+message);
		message = "Conversation ready!";
		sendMessage(message);
		ServerConnectedClientsPanel.addElementToList(sessionID + "/" + "USERNAME" + clientIP);
		isAlive = true;
	}
	
	private String generateSessionID() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 5; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		try {
			Message<String, Object> message;
			setupStreams();
			greetUser();
			do {
				try {
					message = (Message<String, Object>) input.readObject();
					TCPServer.putTask(message);
//					if(message.getString().substring(0,6).equals("ALIAS%")) {
//						clientAlias = message.getString().substring(6); 
//						ServerConnectedClientsPanel.addElementToList(sessionID + "/" + clientAlias + clientIP);
//					}
					serviceMessage(message.getString());
				} catch(Exception e) {
					break;
				}
			} while(!message.equals("%DISCONNECT%"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if(this.isAlive) cleanUp();
		}
	}

}
