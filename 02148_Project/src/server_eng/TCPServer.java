package server_eng;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import client_eng.User;
import engine.Message;

public class TCPServer extends Thread {
	public static int currentTask = 0;
	private static ArrayList<Message<String, Object>> taskBuffer = new ArrayList<Message<String, Object>>();
	private static HashMap<String, ConnectionThread> allConnections = new HashMap<String, ConnectionThread>();
	private static HashMap<User, String> userMap = new HashMap<User, String>();
	
	private ServerTupleSpace space;
	private ServerSocket server;
	private Socket connection;
	
	private String serverStatus = "";
	
	private boolean isRunning = false;
	private int port;
	
	public static int userCount = 0;
	
	public TCPServer(int port) {
		this.port = port;
	}
	
	private void serviceMessage(String message) {
		String timeStamp = "{" + new Date().toString().substring(11, 19) + "}";
		System.out.println(timeStamp+"[SERVER]"+message);
	}
	
	private static void serviceSTATMessage(String message) {
		String timeStamp = "{" + new Date().toString().substring(11, 19) + "}";
		System.out.println(timeStamp+"[SERVER]"+message);
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
			ConnectionThread newClient = new ConnectionThread(connection);
			newClient.start();
			try {
				Thread.sleep(150);
				serviceMessage("============ All Active Connections ============");
				for(Map.Entry<String, ConnectionThread> entry : allConnections.entrySet()) {
					serviceMessage("| Active connection: " + entry.getKey() + " Thread: " + entry.getValue() + "|");
				}
				serviceMessage("================================================");
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
		User temp = findUser(user);
		if(!userMap.containsKey(temp)) return false;
		if(userMap.get(temp).equals(password)) {
			return true;
		}
		return false;
	}
	
	public boolean newUser(User user, String password) {
		for (Map.Entry<User, String> entry : userMap.entrySet()) {
			if(entry.getKey().getUserName().equals(user.getUserName())) {
				return false;
			}
		}
		userMap.put(user, password);
		for(Map.Entry<User, String> entry : userMap.entrySet()) {
			serviceSTATMessage("User: " + entry.getKey().getUserName() + " Password: " + entry.getValue());
		}
		return true;
	}
	
	public static boolean changeUserPassword(User user, String currentPassword, String newPassword, String sessionID) {
		if(userMap.get(user).equals(currentPassword)) {
			userMap.put(user, newPassword);
			for(Map.Entry<User, String> entry : userMap.entrySet()) {
				serviceSTATMessage("User: " + entry.getKey().getUserName() + " Password: " + entry.getValue());
			}
			return true;
		}
		return false;
	}
	
	public static User findUser(String username) {
		for(Map.Entry<User, String> entry : userMap.entrySet()) {
			if(entry.getKey().getUserName().equals(username)) {
				return entry.getKey();
			}
		}
		return null;
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
