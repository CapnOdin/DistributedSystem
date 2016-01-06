package client_gui;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel implements GeneralProperties{
	
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
