package server_gui;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel implements GeneralProperties {
	
	public PanelTemplate() {
		this.setPreferredSize(frameSize);
		this.setBackground(bg_color);
	}
	
	abstract void setBackgroundColor();
	abstract void setPanelSize();
}
