package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import server_eng.TCPServer;

public class ServerMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension frameSize = new Dimension((int)(800), (int)(410));
	
	private ServerMenuPanel smp;
	private ServerStatusBar ssb;
	
	private ServerPanelTemplate current_panel;
	public static TCPServer server;
	public static int portNumber;
	
	public ServerMainFrame() {
		setDefaultProperties();
		addStaticPanels();
	}

	public static void setupServer() {
		server = new TCPServer(portNumber);
		server.setRunning(true);
		server.start();
	}

	public void addVariablePanel(ServerPanelTemplate panel) {
		removeVariablePanel();
		current_panel = panel;
		panel.setVisible(true);
		this.add(panel, BorderLayout.CENTER);
		this.validate();
		this.pack();
	}
	
	private void removeVariablePanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}
	
	private void addStaticPanels() {
		smp = new ServerMenuPanel(this);
		ssb = new ServerStatusBar(this);
		current_panel = new ServerConnectionPanel(this, "PLACEHOLDER");
		
		this.add(smp, BorderLayout.NORTH);
		this.add(current_panel, BorderLayout.CENTER);
		this.add(ssb, BorderLayout.SOUTH);
	}

	private void setDefaultProperties() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           
        }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(frameSize);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.black);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public ServerPanelTemplate getCurrent_panel() {
		return current_panel;
	}
	
	public static void main(String[] args) {
		new ServerMainFrame();
	}

}
