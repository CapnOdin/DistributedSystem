package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer implements Runnable {
	
	private static ArrayList<String> taskBuffer = new ArrayList<String>();
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	private ServerSocket server;
	private Socket connection;
	
	private ArrayList<ConnectionThread> allConnections = new ArrayList<ConnectionThread>();
	private int userCount = 0;
	
	private int port;
	public static int currentTask = 0;
	
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
				taskBuffer.add(message);
				System.out.println(taskBuffer.toString());
			} catch(Exception e) {
				e.printStackTrace();
			}
		} while(!message.equals("CLIENT - END"));
	}

	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("[SERVER]Streams successfully created.");
	}

	private void waitForConnection() throws IOException {
		System.out.println("[SERVER]Waiting for someone to connect...");
		connection = server.accept();
		System.out.println(allConnections.size());
		System.out.println("[SERVER]Now connected to " + connection.getInetAddress().getHostName());
		ConnectionThread newClient = new ConnectionThread(connection, userCount++);
		allConnections.add(newClient);
		newClient.start();
	}

	private void cleanUp() {
		System.out.println("[SERVER]Connections closed");
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

	public static ArrayList<String> getTaskBuffer() {
		return taskBuffer;
	}

	public void setTaskBuffer(ArrayList<String> taskBuffer) {
		this.taskBuffer = taskBuffer;
	}

}
