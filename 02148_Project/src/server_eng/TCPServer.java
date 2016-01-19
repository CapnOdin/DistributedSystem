package server_eng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import client_eng.Profile;
import engine.Message;

public class TCPServer extends Thread {
	public static int currentTask = 0;
	private static ArrayList<Message<String, Object>> taskBuffer = new ArrayList<Message<String, Object>>();
	private static HashMap<String, ConnectionThread> allConnections = new HashMap<String, ConnectionThread>();
	private static HashMap<String, String> userMap = new HashMap<String, String>();
	
	private ServerTupleSpace space;
	private ServerSocket server;
	private Socket connection;
	private Profile dummyProfile = new Profile();
	
	private String serverStatus = "";
	
	private boolean isRunning = false;
	private int port;
	
	public static int userCount = 0;
	public static int userNumber = 0;
	
	public TCPServer(int port) {
		this.port = port;
	}
	
	private void serviceMessage(String message) {
		System.out.println("[SERVER]"+message);
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
			serviceMessage(serverStatus);
			connection = server.accept();
			serverStatus = "Now connected to " + connection.getRemoteSocketAddress();
			userCount++;
			serviceMessage(serverStatus);
			ConnectionThread newClient = new ConnectionThread(connection, userNumber++, dummyProfile);
			newClient.start();
			try {
				Thread.sleep(150);
				System.out.println(allConnections);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void cleanUp() {
		serverStatus = "Connections closed";
		serviceMessage(serverStatus);
		try {
			connection.close();
			server.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Message<String, Object>> getTaskBuffer() {
		return taskBuffer;
	}
	
	public static void putTask(Message<String, Object> message) {
		taskBuffer.add(message);
	}
	
	public static void removeConnection(String key) {
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
	
	public static boolean changeUserPassword(String name, String currentPassword, String newPassword, String sessionID) {
		if(userMap.get(name).equals(currentPassword)) {
			userMap.put(name, userMap.get(name) + 1);
			return true;
		}
		return false;
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
