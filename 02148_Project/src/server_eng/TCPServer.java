package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	private ServerSocket server;
	private Socket connection;
	
	private int port;
	
	public TCPServer(int port) {
		this.port = port;
	}

	private void serverSleepMode() {
		while(true) {
			try {
				waitForConnection();
				setupStreams();
				whileConnected();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				cleanUp();
				System.exit(1);
			}
		}
	}
	
	private void sendMessage(String message) {
		try {
			output.writeObject("SERVER - " + message);
			output.flush();
			//System.out.println("SERVER - " + message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void whileConnected() throws IOException {
		String message = "Conversation ready!";
		sendMessage(message);
		do {
			try {
				message = (String) input.readObject();
				System.out.println(message);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(!message.equals("CLIENT - END"));
	}

	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("Input and Output streams are now set up.");
	}

	private void waitForConnection() throws IOException {
		System.out.println("Waiting for someone to connect...");
		connection = server.accept();
		System.out.println("Now connected to " + connection.getInetAddress().getHostName());
	}

	private void cleanUp() {
		System.out.println("Closing connections");
		try {
			output.close();
			input.close();
			connection.close();
			server.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket(port, 100);
		} catch(Exception e) {
			e.printStackTrace();
		}
		serverSleepMode();
	}

}
