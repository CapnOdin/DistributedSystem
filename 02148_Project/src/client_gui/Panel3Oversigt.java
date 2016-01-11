package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel3Oversigt extends PanelTemplate implements GeneralProperties{
	private MainFrame parent;
	
	public Panel3Oversigt(MainFrame parent){
		this.parent = parent;
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		//this.add(panel);
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.orange);
		this.setPreferredSize(frameSizePanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}
	
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel3Oversigt());
		test.validate();
	}

}
