package client_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	private String message = "";
	private String serverIP;
	
	private Socket connection;
	
	public TCPClient(String host) {
		serverIP = host;
	}
	
	public void run() {
		try {
			connectToServer();
			setupStreams();
			whileConnected();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			cleanUp();
		}
	}
	
	public void sendMessage(String message) {
		try {
			output.writeObject("CLIENT - " + message);
			output.flush();
			//System.out.println("CLIENT - " + message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void whileConnected() throws IOException {
		do {
			try {
				message = (String) input.readObject();
				System.out.println(message);
				sendMessage("Hello");
				sendMessage("EEND");
			}catch(Exception e) {
				e.printStackTrace();
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
		connection = new Socket(InetAddress.getByName(serverIP), 1234);
		System.out.println("[CLIENT]Connected to " + connection.getInetAddress().getHostName());
	}

	private void cleanUp() {
		System.out.println("[CLIENT]Closing connection and streams.");
		try {
			output.close();
			input.close();
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
