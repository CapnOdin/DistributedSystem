package client_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import engine.Message;

public class TCPClient extends Thread {
	private ObjectOutputStream output;
	private ObjectInputStream input;

	public static boolean isConnected = false;

	private Message<String, Object> message = null;
	private String serverIP;
	private String alias;
	public static String sessionID;
	private int port;

	private Socket connection;

	public TCPClient(String host, int port, String alias) {
		serverIP = host;
		this.port = port;
		this.alias = alias;
	}

	private void serviceMessage(String message) {
		System.out.println("[CLIENT]" + message);
	}

	private void decode(Message<String, Object> message) {
		String[] decoded = message.getString().split("\\.");
		if (decoded.length > 0) {
			client_gui.MainFrame.msg = decoded;
		}
		switch (decoded[0]) {
		case "A0":
			// CONNECTION
			if (decoded[1].equals("TRUE")) {
				isConnected = true;
				serviceMessage("AUTHENTICATION TRUE");
			}
			if (decoded[1].equals("FALSE")) {
				serviceMessage("AUTHENTICATION FALSE");
			}
			break;
		case "A1":
			// NEW USER
			if (decoded[1].equals("TRUE")) {
				serviceMessage("SERVER CREATED USER");
			}
			if (decoded[1].equals("FALSE")) {
				serviceMessage("USER ALREADY EXISTS");
			}
			break;
		case "A2":
			// AUTHENTICATION
			if (decoded[1].equals("TRUE")) {
				sessionID = decoded[2];
				serviceMessage("SESSION ID SET TO: " + sessionID);
			}
			if (decoded[1].equals("FALSE")) {

			}
			break;
		case "A5":
			// Kicked from server
			serviceMessage("Server kicked you! reason: " + decoded[1]);
			disconnect();
			break;
		case "#":
			if (decoded[1].equals("besked")) {
				// ...
			}
		default:
			serviceMessage("Message \"" + java.util.Arrays.toString(decoded) + "\" couldn't be decoded.");
			break;
		}
	}

	public void run() {
		try {
			connectToServer();
			setupStreams();
			whileConnected();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isConnected)
				cleanUp();
		}
	}

	public void sendMessage(String message) {
		Message<String, Object> m = new Message<String, Object>(message);
		try {
			output.writeObject(m);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message, Object object) {
		Message<String, Object> m = new Message<String, Object>(message, object);
		try {
			output.writeObject(m);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void whileConnected() throws IOException {
		sendMessage("ALIAS%" + alias);
		do {
			try {
				message = (Message<String, Object>) input.readObject();
				serviceMessage(message.toString());
				decode(message);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		} while (!message.getString().contains("A3"));
	}

	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		serviceMessage("Streams successfully created.");
	}

	private void connectToServer() throws IOException {
		serviceMessage("Attempting connection...");
		connection = new Socket(InetAddress.getByName(serverIP), port);
		serviceMessage("Connected to " + connection.getInetAddress().getHostName());
	}

	public void disconnect() {
		serviceMessage("Disconnecting Client..");
		sendMessage("%DISCONNECT%");
		isConnected = false;
		cleanUp();
	}

	private void cleanUp() {
		try {
			output.close();
			input.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceMessage("Closing connection and streams.");
	}

	public static String getSessionID() {
		return sessionID;
	}

}
