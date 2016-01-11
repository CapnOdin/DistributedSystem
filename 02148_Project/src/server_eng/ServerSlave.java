package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.Timer;

public class ServerSlave implements Runnable {
	
	private ServerTupleSpace space;
	
	private HashMap<String, TaskTemplate> inst_mem = new HashMap<String, TaskTemplate>();
	
	public ServerSlave(ServerTupleSpace space) {
		this.space = space;
	}

	@Override
	public void run() {
		
			//String instruction = TCPServer.getTaskBuffer().get(TCPServer.currentTask++);
			//TaskTemplate current_task = inst_mem.get(instruction);
			//current_task.runTask(space);
			Timer t = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(TCPServer.getTaskBuffer().get(TCPServer.currentTask));
				}
			});
			t.start();	
			
		
	}

}
