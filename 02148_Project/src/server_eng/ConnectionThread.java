package server_eng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.Timer;

public class ConnectionThread extends Thread {
	
	private Socket client;
	private int userNo;
	
	public ConnectionThread(Socket client, int userNo) {
		this.client = client;
		this.userNo = userNo;
	}
	
	@Override
	public void run() {
		Timer t = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello from " + client.getInetAddress() + " user number " + userNo + " server connection thread.");
			}
		});
		t.start();	
		super.run();
	}
}
