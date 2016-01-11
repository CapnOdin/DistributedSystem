package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.Timer;

public class ServerSlave implements Runnable {

	private ServerTupleSpace space;

	public ServerSlave(ServerTupleSpace space) {
		this.space = space;
	}

	private void decodeTask(String task) {
		String[] decoded = task.split("\\.");
		try {
			switch (decoded[0]) {
			case "A0":
				System.out.println("DECODED STRING INSTRUCTION CODE: " + decoded[0]);
				break;
			case "A1":
				break;
			case "A2":
				break;
			case "A3":
				break;
			case "A4":
				break;
			case "A5":
				break;
			case "A6":
				break;
			case "A7":
				break;
			case "A8":
				break;
			case "A9":
				break;
			default:
				System.out.println("Message \"" + java.util.Arrays.toString(decoded) + "\" couldn't be decoded.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		// String instruction =
		// TCPServer.getTaskBuffer().get(TCPServer.currentTask++);
		// TaskTemplate current_task = inst_mem.get(instruction);
		// current_task.runTask(space);
		Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(TCPServer.getTaskBuffer().get(TCPServer.currentTask));
				decodeTask(TCPServer.getTaskBuffer().get(TCPServer.currentTask));
			}
		});
		t.start();

	}

}
