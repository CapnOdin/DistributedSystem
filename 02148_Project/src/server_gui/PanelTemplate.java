package server_gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel implements GeneralProperties, ActionListener {
	
	public PanelTemplate() {
		this.setVisible(true);
		this.setPreferredSize(new Dimension(GeneralProperties.frameSize.width, GeneralProperties.frameSize.height));
		setBackgroundColor();
		setup();
		this.validate();
	}
	
	abstract void setBackgroundColor();
	abstract void setup();
}
