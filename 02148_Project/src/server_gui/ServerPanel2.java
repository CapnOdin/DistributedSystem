package server_gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ServerPanel2 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton[] buts = new JButton[600];
	
	public ServerPanel2() {
		this.setLayout(new GridLayout(30,20));
		for(int i = 0; i < buts.length; i++) {
			buts[i] = new JButton(".");
			buts[i].setBackground(Color.white);
			this.add(buts[i]);
		}
		this.validate();
	}

}
