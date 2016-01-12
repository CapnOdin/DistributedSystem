package tests;

import client_eng.TCPClient;
import server_eng.TCPServer;

public class ConnectionTest {
	
	public static void main(String[] args) {
		(new Thread(new TCPServer(1234))).start();
		
		(new Thread(new TCPClient("localhost", 1234))).start();
		
		TCPClient c2 = new TCPClient("localhost", 1234);
		c2.run();
		
	}
}
