package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

public class DataPanel3 extends PanelTemplate{
	private static final long serialVersionUID = 1L;
	private DataPanel3Data dp3Data;
	private DataPanel3Connect dp3Connect;
	private DataPanel3Kalender dp3Kalender;
	private DataPanel3Oversigt dp3Oversigt;

	
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
		this.add(dp3Data);
		this.add(dp3Connect);

			

	}
}
