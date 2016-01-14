package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server_gui.ServerConnectedClientsPanel;

public class ConnectionThread extends Thread {
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private String clientAlias;
	private String clientIP = "";
	
	private Socket client;
	private int userNo;
	
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
			TCPServer.removeConnection(userNo);
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
	
	private void sendMessage(String message) {
		try {
			output.writeObject("[THREAD " + userNo + "]" + message);
			output.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectClient() { 
		sendMessage("Disconnected from server");
		cleanUp();
	}
	
	@Override
	public void run() {
		//super.run();
		try {
			setupStreams();
			String message = "Conversation ready!";
			sendMessage(message);
			do {
				try {
					message = (String) input.readObject();
					TCPServer.putTask(message);
					if(message.substring(0,6).equals("ALIAS%")) {
						clientAlias = message.substring(6); 
						ServerConnectedClientsPanel.addElementToList(userNo + "/" + clientAlias + clientIP);
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
