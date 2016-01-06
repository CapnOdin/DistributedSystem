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
			String instruction = masterServer.getTaskBuffer().get(masterServer.currentTask++);
			TaskTemplate current_task = inst_mem.get(instruction);
			current_task.runTask(space);
		}
	}

}
