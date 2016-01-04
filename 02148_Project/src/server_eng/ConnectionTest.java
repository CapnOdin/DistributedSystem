package server_eng;

import client_eng.TCPClient;

public class ConnectionTest {
	
	public static void main(String[] args) {
		(new Thread(new TCPServer(1234))).start();
		
		TCPClient client = new TCPClient("localhost");
		client.run();
	}
}
