package server_eng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class TCPServer implements Runnable {
	
	private static ArrayList<String> taskBuffer = new ArrayList<String>();
	public static int currentTask = 0;
	
	private ArrayList<ConnectionThread> allConnections = new ArrayList<ConnectionThread>();
	private HashMap<Integer, ConnectionThread> allConnections2 = new HashMap<Integer, ConnectionThread>();
	
	private ServerTupleSpace space;
	private ServerSocket server;
	private Socket connection;
	
	private int port;
	private int userCount = 0;
	
	public TCPServer(int port) {
		this.port = port;
	}

	private void serverSleepMode() {
		//setupSlave();
		while(true) {
			try {
				waitForConnection();
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				cleanUp();
				System.exit(0);
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
			ConnectionThread newClient = new ConnectionThread(connection, userCount);
			allConnections.add(newClient);
			
			allConnections2.put(userCount++, newClient);
			System.out.println(allConnections2);
			
			newClient.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
