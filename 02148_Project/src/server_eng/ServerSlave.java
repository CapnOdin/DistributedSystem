package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import api.GoogleWebApi;
import client_eng.Profile;
import server_gui.ServerConnectedClientsPanel;

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
				//Authenticate User
				System.out.println("Authenticating user ...");
				if(server.authenticate(decoded[1], decoded[2])) {
					// Authentication succeeded
					System.out.println("[SERVER]Authentication OK " + decoded[decoded.length-1]);
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A0.TRUE");
				} else {
					// Authentication failed
					System.out.println("[SERVER]Authentication FAILED");
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A0.FALSE");
				}
				break;
			case "A1":
				//Calculate distance
				System.out.println("DECODED STRING " + java.util.Arrays.toString(decoded));
				System.out.println(GoogleWebApi.distMatrix(GoogleWebApi.seachPlaces(decoded[1]).get(1), GoogleWebApi.seachPlaces(decoded[2]).get(1)));
				break;
			case "A2":
				//Disconnect client
				System.out.println("DECODED STRING " + java.util.Arrays.toString(decoded));
				ServerConnectedClientsPanel.removeElementFromList(decoded[1]);
				TCPServer.getAllConnections().get(decoded[1]).disconnectClient();
				break;
			case "A3":
				break;
			case "A4":
				break;
			case "A5":
				break;
			case "A6":
				//Connect with moment.
				String momentUsername = decoded[1], momentPassword = decoded[2], sessionID = decoded[3];
				TCPServer.getAllConnections().get(sessionID).getProfile().setMomentUsername(momentUsername);
				TCPServer.getAllConnections().get(sessionID).getProfile().setMomentPassword(momentPassword);
				break;
			case "A7":
				//Get todays plan.
				break;
			case "A8":
				//Edit client profile.
				Profile temp = new Profile(decoded[1], decoded[2], decoded[3], decoded[4], decoded[5], decoded[6],decoded[7], decoded[8]);
				TCPServer.getAllConnections().get(decoded[9]).setProfile(temp);
				break;
			case "A9":
				//Want ride?
				String wantRide = decoded[1], haveCar = decoded[2], sessionIDA9 = decoded[3];
				break;
			case "A10":
				if(server.newUser(decoded[1], decoded[2])) {
					System.out.println("[SERVER]ADDED NEW USER");
					//TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A1.TRUE");
				} else {
					System.out.println("[SERVER]USER ALREADY EXISTS");
					//TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A1.FALSE");
				}
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
		Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					decodeTask(TCPServer.getTaskBuffer().get(TCPServer.currentTask));
				} catch(Exception ex) {
				
				}			
			}
		});
		t.start();
	}

}
