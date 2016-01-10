package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class DataPanel3Oversigt extends PanelTemplate implements GeneralProperties{

	public DataPanel3Oversigt(){
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		this.add(panel);
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.orange);
		this.setPreferredSize(frameSizeDataPanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}

}
