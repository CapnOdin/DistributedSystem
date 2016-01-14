package engine;

import client_eng.TCPClient;

public class ClientEngine {
	public static void main(String[] args) {
		new TCPClient("localhost", 1234, "Matt").start();
	}
}
