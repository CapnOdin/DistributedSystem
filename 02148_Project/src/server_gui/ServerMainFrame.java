package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ServerMainFrame extends JFrame implements ServerProperties {

	private static final long serialVersionUID = 1L;
	private ServerTaskBar stb;
	private MenusPanel mp;
	
	private JPanel current_panel = new JPanel();
	
	public ServerMainFrame() {
		setDefaultProperties();
		addTaskBar();
		addMenusPanel();
		this.validate();
	}
	
	public void removeCenterPanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}

	public void addCenterPanel(JPanel panel) {
		current_panel = panel;
		this.add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}

	private void addMenusPanel() {
		mp = new MenusPanel(this);
		this.add(mp, BorderLayout.SOUTH);
	}

	private void addTaskBar() {
		stb = new ServerTaskBar(this, "Server");
		this.add(stb, BorderLayout.NORTH);
	}

	private void setDefaultProperties() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
