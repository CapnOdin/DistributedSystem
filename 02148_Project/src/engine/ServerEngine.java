package engine;

import server_eng.TCPServer;

public class ServerEngine {
	public static void main(String[] args) {
		new TCPServer(1234).run();
	}
}
