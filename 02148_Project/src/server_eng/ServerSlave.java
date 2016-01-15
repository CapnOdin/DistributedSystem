package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.Timer;

import api.GoogleWebApi;

public class ServerSlave implements Runnable {

	private ServerTupleSpace space;
	private TCPServer server;
	
	public ServerSlave(ServerTupleSpace space, TCPServer server) {
		this.server = server;
		this.space = space;
	}

	private void decodeTask(String task) {
		String[] decoded = task.split("\\.");
		try {
			switch (decoded[0]) {
			case "A0":
				System.out.println("Authenticating user ...");
				if(server.authenticate(decoded[1], decoded[2])) {
					// Authentication succeeded
					System.out.println("Authentication OK");
				} else {
					// Authentication failed
					System.out.println("Authentication FAILED");
				}
				break;
			case "A1":
				System.out.println("DECODED STRING " + java.util.Arrays.toString(decoded));
				System.out.println(GoogleWebApi.distMatrix(GoogleWebApi.seachPlaces(decoded[1]).get(1), GoogleWebApi.seachPlaces(decoded[2]).get(1)));
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
			case "A10":
				server.newUser(decoded[1], decoded[2]);
				break;
			default:
				System.out.println("Message \"" + java.util.Arrays.toString(decoded) + "\" couldn't be decoded.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TCPServer.getTaskBuffer().remove(TCPServer.currentTask);
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
				try {
					decodeTask(TCPServer.getTaskBuffer().get(TCPServer.currentTask));
				} catch(Exception ex) {
					//System.out.println("HELLO");
				}
				
			}
		});
		t.start();

	}

}
