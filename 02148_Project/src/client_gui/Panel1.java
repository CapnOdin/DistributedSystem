package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends PanelTemplate implements GeneralProperties{	
	
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridLayout());
	private JLabel JLForbundet;
	
	public Panel1(MainFrame parent){
		this.parent = parent; 
		addForbundet();
	}

	@Override
	void setDefaultProperties() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizePanel1);
		this.setVisible(true);
		this.validate();
		
	}
	
	public void addForbundet(){	
		JLForbundet = new JLabel(" Forbundet ");
		panel.setBackground(Color.white);
		JLForbundet.setForeground(Color.gray);
		panel.add(JLForbundet);
		this.add(panel, BorderLayout.EAST);
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
