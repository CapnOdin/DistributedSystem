package server_eng;

import java.util.HashMap;

public class ServerSlave implements Runnable {
	
	private ServerTupleSpace space;
	
	private HashMap<String, TaskTemplate> inst_mem = new HashMap<String, TaskTemplate>();
	
	public ServerSlave(ServerTupleSpace space) {
		this.space = space;
	}

	@Override
	public void run() {
		while(true) {
			String instruction = TCPServer.getTaskBuffer().get(TCPServer.currentTask++);
			TaskTemplate current_task = inst_mem.get(instruction);
			current_task.runTask(space);
		}
	}

}
