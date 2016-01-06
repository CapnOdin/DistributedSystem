package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DataPanel3 extends PanelTemplate{
	private static final long serialVersionUID = 1L;
	private GridBagConstraints c = new GridBagConstraints();
	private DataPanel3Data dp3Data;
	private DataPanel3Connect dp3Connect;
	private DataPanel3Kalender dp3Kalender;
	private DataPanel3Oversigt dp3Oversigt;
	private JTextField name, adress;
	private JLabel picture;
	
	@Override
	void setBackgroundColor() {
		this.setBackground(Color.white);
		this.validate();
	}

	@Override
	void setup() {
		dp3Data = new DataPanel3Data();
		dp3Connect = new DataPanel3Connect();
		dp3Kalender = new DataPanel3Kalender();
		dp3Oversigt = new DataPanel3Oversigt();
		
	}

	
	private void setGridBagConstraints(int x, int y, int height, int width, int spacex, int spacey){
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.ipady = height;
		c.gridwidth = width;
		c.weightx = spacex;
		c.weighty = spacey;
	}

}
