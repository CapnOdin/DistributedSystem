package server_gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel {
	
	public PanelTemplate() {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(GeneralProperties.frameSize.width, GeneralProperties.frameSize.height));
		setBackgroundColor();
		setup();
		this.validate();
	}
	
	abstract void setBackgroundColor();
	abstract void setPanelSize();
	abstract void setup();
}
