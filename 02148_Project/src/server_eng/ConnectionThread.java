package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import server_gui.ServerConnectedClientsPanel;

public class ConnectionThread extends Thread {
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private String clientAlias;
	private String clientIP = "";
	
	private Socket client;
	private int userNo;
	private String sessionID;
	
	public ConnectionThread(Socket client, int userNo) {
		this.client = client;
		this.userNo = userNo;
		clientIP = client.getRemoteSocketAddress().toString();
	}
	
	private void cleanUp() {
		try {
			input.close();
			output.close();
			client.close();
			TCPServer.removeConnection(sessionID);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("[SERVER]Thread " + client.getInetAddress() + " closed.");
	}
	
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		System.out.println("[THREAD "+ userNo + "]Streams successfully created.");
	}
	
	public void sendMessage(String message) {
		try {
			output.writeObject(message);
			output.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectClient() { 
		sendMessage("Disconnected from server");
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
	
	@Override
	public void run() {
		try {
			String message = "";
			setupStreams();
			greetUser();
			do {
				try {
					message = (String) input.readObject();
					TCPServer.putTask(message);
					if(message.substring(0,6).equals("ALIAS%")) {
						clientAlias = message.substring(6); 
						ServerConnectedClientsPanel.addElementToList(sessionID + "/" + clientAlias + clientIP);
					}
					System.out.println(message);
				} catch(Exception e) {
					break;
				}
			} while(!message.equals("%DISCONNECT%"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			cleanUp();
		}
	}

}
