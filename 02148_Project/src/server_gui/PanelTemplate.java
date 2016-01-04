package server_gui;

import javax.swing.JPanel;

public abstract class PanelTemplate extends JPanel implements GeneralProperties {
	
	public PanelTemplate() {
		this.setVisible(true);
		setBackgroundColor();
	}
	
	abstract void setBackgroundColor();
	abstract void setPanelSize();
}
