package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server_gui.ServerConnectedClientsPanel;

public class ConnectionThread extends Thread {
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private Socket client;
	private int userNo;
	
	public ConnectionThread(Socket client, int userNo) {
		this.client = client;
		this.userNo = userNo;
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
	
	@Override
	public void run() {
		//super.run();
		try {
			setupStreams();
			String message = "Conversation ready!";
			sendMessage(message);
			ServerConnectedClientsPanel.addElementToList(client.getRemoteSocketAddress().toString());
			do {
				try {
					message = (String) input.readObject();
					TCPServer.putTask(message);
				} catch(Exception e) {
					break;
				}
			} while(!message.equals("ENDCONNECTION"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			cleanUp();
		}
	}
}
