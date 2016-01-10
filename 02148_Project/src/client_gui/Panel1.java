package client_gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Panel1 extends PanelTemplate implements GeneralProperties{	
	
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	
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
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel1);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel1());
		test.validate();
	}


}
