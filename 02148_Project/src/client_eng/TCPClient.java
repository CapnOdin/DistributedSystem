package client_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient extends Thread {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	private String message = "";
	private String serverIP;
	private String alias;
	
	private int port;
	
	private Socket connection;
	
	public TCPClient(String host, int port, String alias) {
		serverIP = host;
		this.port = port;
		this.alias = alias;
	}
	
	public void run() {
		try {
			connectToServer();
			setupStreams();
			whileConnected();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("CLIENT DEAD");
			cleanUp();
		}
	}
	
	public void sendMessage(String message) {
		try {
			output.writeObject(message);
			output.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void whileConnected() throws IOException {
		sendMessage("ALIAS%"+alias);
		do {
			try {
				message = (String) input.readObject();
				System.out.println(message);
			}catch(Exception e) {
				break;
			}
		}while(!message.equals("SERVER - END"));
	}

	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("[CLIENT]Streams successfully created.");
	}

	private void connectToServer() throws IOException {
		System.out.println("[CLIENT]Attempting connection...");
		connection = new Socket(InetAddress.getByName(serverIP), port);
		System.out.println("[CLIENT]Connected to " + connection.getInetAddress().getHostName());
	}

	private void cleanUp() {
		try {
			output.close();
			input.close();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("[CLIENT]Closing connection and streams.");
	}

}
