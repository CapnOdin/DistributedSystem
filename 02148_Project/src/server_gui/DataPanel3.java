package server_gui;

import java.awt.Color;
import java.awt.Dimension;

public class DataPanel3 extends PanelTemplate{
	private static final long serialVersionUID = 1L;
	
	@Override
	void setBackgroundColor() {
		this.setBackground(Color.white);
		this.validate();
	}

	@Override
	void setPanelSize() {
		this.setPreferredSize(new Dimension(GeneralProperties.frameSize.width, (GeneralProperties.frameSize.height/10)*7));
		
	}

	@Override
	void setup() {
		// TODO Auto-generated method stub
		
	}
}
