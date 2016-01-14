package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends PanelTemplate implements GeneralProperties{	
	
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private static JPanel panel = new JPanel(new GridLayout());
	private static JLabel JLForbundet = new JLabel(" Forbundet ");
	
	public Panel1(MainFrame parent){
		//JLForbundet.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		JLForbundet.setForeground(Color.gray);
		panel.setBackground(Color.white);
		panel.add(JLForbundet);
		JLForbundet.setVisible(false);
		this.parent = parent; 
		this.add(panel, BorderLayout.EAST);
		this.setVisible(true);
	}

	@Override
	void setDefaultProperties() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizePanel1);
		this.setVisible(true);
		this.validate();
		
	}
	
	public static void addForbundet(){	
		JLForbundet.setVisible(true);
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
