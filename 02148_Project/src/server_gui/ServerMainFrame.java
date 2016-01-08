package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class ServerMainFrame extends JFrame implements ServerProperties {

	private static final long serialVersionUID = 1L;
	private ServerTaskBar stb;

	public ServerMainFrame() {
		setDefaultProperties();
		addTaskBar();
	}

	private void addTaskBar() {
		stb = new ServerTaskBar(this);
		this.add(stb, BorderLayout.NORTH);
		this.validate();
	}

	private void setDefaultProperties() {
		this.setPreferredSize(serverFrameSize);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new ServerMainFrame();
	}

}
