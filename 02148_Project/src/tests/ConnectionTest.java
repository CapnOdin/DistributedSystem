package tests;

import client_eng.TCPClient;
import server_eng.TCPServer;

public class ConnectionTest {
	
	public static void main(String[] args) {
		(new Thread(new TCPServer(1234))).start();
		
		TCPClient client = new TCPClient("localhost", 1234);
		client.run();
	}
}
