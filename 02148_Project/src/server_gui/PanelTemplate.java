package server_gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel implements GeneralProperties {
	
	public PanelTemplate() {
		this.setVisible(true);
		System.out.println();
		this.setPreferredSize(new Dimension(frameSize.width, frameSize.height));
		setBackgroundColor();
		setup();
		this.validate();
	}
	
	abstract void setBackgroundColor();
	abstract void setPanelSize();
	abstract void setup();
}
