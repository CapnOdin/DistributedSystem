package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

import client_eng.Profile;
import client_eng.User;
import engine.Message;
import server_gui.ServerConnectedClientsPanel;

public class ServerSlave implements Runnable {

	private ServerTupleSpace space;
	private TCPServer server;
	
	public ServerSlave(ServerTupleSpace space, TCPServer server) {
		this.server = server;
		this.space = space;
	}
	
	private void serviceMessage(String message) {
		String timeStamp = "{" + new Date().toString().substring(11, 19) + "}";
		System.out.println("[SERVERSLAVE]"+timeStamp+message);
	}

	private void decodeTask(Message<String, Object> message) {
		String[] decoded = message.getString().split("\\.");
		try {
			switch (decoded[0]) {
			case "A0":
				//Authenticate User
				serviceMessage("Authenticating user ...");
				if(server.authenticate(decoded[1], decoded[2])) {
					// Authentication succeeded
					serviceMessage("Authentication OK " + decoded[decoded.length-1]);
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A0.TRUE", TCPServer.findUser(decoded[1]).getProfile());
					//TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A0.TRUE");
				} else {
					// Authentication failed
					serviceMessage("Authentication FAILED");
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A0.FALSE");
				}
				break;
			case "A1":
				//Calculate distance
				serviceMessage("DECODED STRING " + java.util.Arrays.toString(decoded));
				//serviceMessage(GoogleWebApi.distMatrix(GoogleWebApi.seachPlaces(decoded[1]).get(1), GoogleWebApi.seachPlaces(decoded[2]).get(1)));
				break;
			case "A2":
				//Disconnect client
				serviceMessage("DECODED STRING " + java.util.Arrays.toString(decoded));
				ServerConnectedClientsPanel.removeElementFromList(decoded[1]);
				TCPServer.getAllConnections().get(decoded[1]).disconnectClient("clientLEFT");
				break;
			case "A3":
				break;
			case "A4":
				break;
			case "A5":
				break;
			case "A6":
				//Connect with moment.
				break;
			case "A7":
				//Get todays plan.
				break;
			case "A8":
				//Edit client profile.
				serviceMessage("DECODED STRING " + java.util.Arrays.toString(decoded));
				serviceMessage(((Profile)message.getObject()).username + " ATTEMPTING TO EDIT PROFILE ...");
				TCPServer.findUser(((Profile)message.getObject()).username).setProfile((Profile)message.getObject());
				try {
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A4.TRUE");
				} catch(NullPointerException ex) {
					serviceMessage("CONNECTION IS CLOSED AND COULDN'T RESPOND TO CLIENT FOR THE PROFILE UPDATE");
				}
				
				break;
			case "A9":
				//Want ride?
				String wantRide = decoded[1], haveCar = decoded[2], sessionIDA9 = decoded[3];
				break;
			case "A10":
				if(server.newUser(new User(decoded[1], new Profile()), decoded[2])) {
					serviceMessage("ADDED NEW USER");
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A1.TRUE");
				} else {
					serviceMessage("USER ALREADY EXISTS");
					TCPServer.getAllConnections().get(decoded[3]).sendMessage("A1.FALSE");
				}
				break;
			case "A13":
				if(TCPServer.changeUserPassword(TCPServer.findUser(decoded[1]), decoded[2], decoded[3], decoded[decoded.length-1])) {
					serviceMessage("CHANGED USER PASSWORD");
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A6.TRUE");
				} else {
					serviceMessage("USER PASSWORD WRONG - CANT CHANGE");
					TCPServer.getAllConnections().get(decoded[decoded.length-1]).sendMessage("A6.FALSE");
				}
				break;
			case "A14":
				// Register Time. RECEIVED STRING: A14.Date.AppointmentName.Address.ZipCode.StartTime.EndTime.BreakTime.sessionID.
 				
				break;
			case "A15":
				break;
			default:
				serviceMessage("Message \"" + java.util.Arrays.toString(decoded) + "\" couldn't be decoded.");
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
