package server_eng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class TCPServer extends Thread {
	
	private static ArrayList<String> taskBuffer = new ArrayList<String>();
	private HashMap<String, String> userMap = new HashMap<String, String>();
	public static int currentTask = 0;
	
	private static HashMap<String, ConnectionThread> allConnections = new HashMap<String, ConnectionThread>();
	
	private ServerTupleSpace space;
	private ServerSocket server;
	private Socket connection;
	
	private String serverStatus = "";
	
	private boolean isRunning = false;
	private int port;
	
	public static int userCount = 0;
	public static int userNumber = 0;
	
	public TCPServer(int port) {
		this.port = port;
	}

	private void serverSleepMode() {
		setupSlave();
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
		(new Thread(new ServerSlave(space,this))).start();
	}
	
	private void waitForConnection() throws IOException {	
		while(true) {
			serverStatus = "Waiting for someone to connect ...";
			System.out.println("[SERVER]Waiting for someone to connect...");
			connection = server.accept();
			serverStatus = "Now connected to " + connection.getRemoteSocketAddress();
			userCount++;
			System.out.println("[SERVER]Now connected to " + connection.getRemoteSocketAddress());
			ConnectionThread newClient = new ConnectionThread(connection, userNumber);
			System.out.println(allConnections);
			newClient.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void cleanUp() {
		serverStatus = "Connections closed";
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
	
	public static void removeConnection(int key) {
		if(allConnections.containsKey(key)) {
			allConnections.remove(key);
		}
		System.out.println(allConnections);
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
	
	public boolean authenticate(String user, String password) {
		if(!userMap.containsKey(user)) return false;
		if(userMap.get(user).equals(password))
			return true;
		else return false;
	}
	
	public boolean newUser(String name, String password) {
		if(!userMap.containsKey(name)) {
			userMap.put(name, password);
			return true;
		} else return false;
	}
	
	public int getPort() {
		return server.getLocalPort();
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public static HashMap<String, ConnectionThread> getAllConnections() {
		return allConnections;
	}

	public String getServerStatus() {
		return serverStatus;
	}

}
