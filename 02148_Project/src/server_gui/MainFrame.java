package server_gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties {
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setDefaultProperties();
	}

	private void setDefaultProperties() {
		this.setPreferredSize(frameSize);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}
	
	

}
