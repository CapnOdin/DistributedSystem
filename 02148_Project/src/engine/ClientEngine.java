package engine;

import client_eng.TCPClient;

public class ClientEngine {
	public static void main(String[] args) {
		for(int i = 0; i < 1; i++) {
			new TCPClient("localhost", 1234).start();
		}
	}
}
