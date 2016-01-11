package server_eng;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer implements Runnable {
	
	private static ArrayList<String> taskBuffer = new ArrayList<String>();
	
	private ServerSlave slave;
	private ServerSocket server;
	private Socket connection;
	
	private ServerTupleSpace space;
	
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
				setupSlave();
				waitForConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				cleanUp();
				System.exit(1);
			}
		}
	}
	
	private void setupSlave() {
		space = new ServerTupleSpace();
		(new Thread(new ServerSlave(space))).start();
	}
	
	private void waitForConnection() throws IOException {
		while(true) {
			System.out.println("[SERVER]Waiting for someone to connect...");
			connection = server.accept();
			System.out.println("[SERVER]Now connected to " + connection.getInetAddress().getHostName());
			ConnectionThread newClient = new ConnectionThread(connection, userCount++);
			allConnections.add(newClient);
			newClient.start();
		}
		
	}

	private void cleanUp() {
		System.out.println("[SERVER]Connections closed");
		try {
			connection.close();
			server.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getTaskBuffer() {
		return taskBuffer;
	}
	
	public static void putTask(String task) {
		taskBuffer.add(task);
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
