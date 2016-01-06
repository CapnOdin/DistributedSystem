package server_eng;

import java.util.HashMap;

public class ServerSlave implements Runnable {
	private ServerTupleSpace space;
	private TCPServer masterServer;
	private HashMap<String, TaskTemplate> inst_mem = new HashMap<String, TaskTemplate>();
	
	
	public ServerSlave(ServerTupleSpace space, TCPServer masterServer) {
		this.space = space; this.masterServer = masterServer;
	}

	@Override
	public void run() {
		while(true) {
			
		}
	}

}
