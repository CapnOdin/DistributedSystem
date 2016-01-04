package server_gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties {

	private static final long serialVersionUID = 1L;
	private DataPanel dp = new DataPanel();
	
	public MainFrame() {
		setDefaultProperties();
		this.add(dp);
	}

	private void setDefaultProperties() {
		this.setPreferredSize(frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}
