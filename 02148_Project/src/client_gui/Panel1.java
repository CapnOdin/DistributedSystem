package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends PanelTemplate implements GeneralProperties{	
	
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel JLForbundet;
	
	public Panel1(MainFrame parent){
		this.parent = parent; 
	}

	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizePanel1);
		this.setVisible(true);
		this.validate();
		
	}
	
	public void addForbundet(){	
		JLForbundet = new JLabel(" Forbundet ");
		JLForbundet.setBackground(Color.white);
		JLForbundet.setForeground(Color.gray);
		JLForbundet.setBorder(BorderFactory.createLineBorder(Color.gray));
		int spaceleft = frameSizePanel1.width - JLForbundet.getWidth()-100;
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(JLForbundet);
		c.insets = new Insets(0,spaceleft,0,0);
		this.add(panel);
		this.setVisible(true);
	}
	/*
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setUndecorated(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel1);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel1());
		test.validate();
	}
	*/

}
