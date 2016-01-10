package client_gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.sun.prism.paint.Color;

public class DataPanel3Kalender extends PanelTemplate implements GeneralProperties{

	
	public DataPanel3Kalender(){
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		this.add(panel);
	}
	
	@Override
	void setDefaultProperties() {
		//this.setBackground(Color.white);
		this.setPreferredSize(frameSizeDataPanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}
}
