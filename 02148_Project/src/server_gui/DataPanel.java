package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DataPanel extends PanelTemplate {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	void setup(){
		
	}

	@Override
	void setBackgroundColor() {
		this.setBackground(Color.orange);
		this.validate();	
	}

	@Override
	void setPanelSize() {
		this.setPreferredSize(new Dimension(frameSize.width, frameSize.height/10));
		
	}
	
	

}
