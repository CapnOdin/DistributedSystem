package server_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client_eng.TCPClient;

public class ServerMenuPanel extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private ServerMainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	
	private ServerConnectedClientsPanel sccp; 
	private ServerTaskBar stb;
	
	private JPanel menusPanel = new JPanel(new GridLayout(1,2));
	private JLabel[] menus = new JLabel[2];
	private Color twitchColor = new Color(100,65,165);
	
	public ServerMenuPanel(ServerMainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		addMenuProperties();
		addMenus();
	}
	
	private void addC(JComponent comp, int gridx, int gridy) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = c.weighty = 1;
		this.add(comp, c);
		this.validate();
	}

	private void addMenus() {
		sccp = new ServerConnectedClientsPanel(parent, "SCCP");
	}

	private void addMenuProperties() {
		stb = new ServerTaskBar(parent, "SERVER");
		menusPanel.setBackground(twitchColor);
		addC(stb, 0, 0);
		for(int i = 0; i < menus.length; i++) {
			menus[i] = new JLabel("", JLabel.CENTER);
			menus[i].addMouseListener(this);
			menus[i].setVisible(true);
			menus[i].setBackground(twitchColor);
			menus[i].setForeground(Color.white);
			menus[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
			menusPanel.add(menus[i]);
		}
		
		menus[0].setText("Connected Clients");
		menus[1].setText("Server Setup");
		addC(menusPanel, 0, 1);
		this.validate();
	}

	private void setDefaultProperties() {
		this.setBackground(twitchColor);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(((JLabel)e.getSource()).getText() + " pressed!");
		
		//Connected Clients Pressed
		if(e.getSource() == menus[0]) {
			menus[0].setBorder(BorderFactory.createLoweredSoftBevelBorder());
			parent.addVariablePanel(sccp);
		}
		
		//Server Setup Pressed
		if(e.getSource() == menus[1]) {
			menus[1].setBorder(BorderFactory.createLoweredSoftBevelBorder());
			TCPClient a = new TCPClient("localhost", 1234, "Matt");
			a.start();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == menus[0]) {
			menus[0].setBorder(BorderFactory.createRaisedSoftBevelBorder());
		}
		if(e.getSource() == menus[1]) {
			menus[1].setBorder(BorderFactory.createRaisedSoftBevelBorder());
		}
		
	}

}
