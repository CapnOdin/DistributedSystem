package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import server_eng.TCPServer;

public class ServerStatusBar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel serverStatus = new JLabel(" Server Status: - ", JLabel.CENTER);
	private JLabel time = new JLabel("", JLabel.CENTER);
	private JLabel connection = new JLabel(" Server: - ", JLabel.CENTER);
	private String publicIP;
	
	public ServerStatusBar(ServerMainFrame parent) {
		setDefaultProperties();
		addElements();
		findPublicIP();
		lookForActivePanel();
	}

	private void findPublicIP() {
		URL whatismyip;
		try {
			whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(
	                whatismyip.openStream()));
			publicIP = in.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addElements() {
		connection.setBackground(Color.black);
		this.add(connection, BorderLayout.WEST);
		this.add(serverStatus, BorderLayout.CENTER);	
		this.add(time, BorderLayout.EAST);
		this.validate();
	}

	private void lookForActivePanel() {
		Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serverStatus.setText(" Server Status: " + ServerMainFrame.server.getServerStatus());
					if(ServerMainFrame.server.isRunning()) {
						connection.setText(" Server: " + publicIP + "/" + ServerMainFrame.server.getPort() + " [" + TCPServer.userCount + "]");
					} else {
						connection.setText(" Server: DEAD ");
					}
					time.setText("Time: " + new Date().toString().substring(11, 19)+ " ");
				} catch(Exception ex) {
					
				}
			}
		});
		t.start();	
		
	}

	private void setDefaultProperties() {
		this.setVisible(true);
		this.setBackground(Color.white);
		//this.setPreferredSize(clientStatusBarSize);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

}
