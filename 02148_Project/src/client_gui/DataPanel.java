package client_gui;

import java.awt.Color;
import java.awt.GridLayout;

public class DataPanel extends PanelTemplate implements GeneralProperties{	
	
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	
	public DataPanel(MainFrame parent){
		this.parent = parent; 
	}

	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizeDataPanel1);
		this.setVisible(true);
		this.validate();
		
	}
	


}
