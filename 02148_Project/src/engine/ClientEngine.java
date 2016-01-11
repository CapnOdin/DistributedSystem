package engine;

import client_eng.TCPClient;

public class ClientEngine {
	public static void main(String[] args) {
		//(new Thread(new TCPClient("localhost", 1234))).start();
		new TCPClient("87.73.124.239", 1234).run();
	}
}
