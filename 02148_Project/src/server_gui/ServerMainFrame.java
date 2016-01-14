package server_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;

import server_eng.TCPServer;

public class ServerMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension frameSize = new Dimension((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private ServerMenuPanel cmp;
	private ServerTaskBar ctb;
	private ServerStatusBar csb;
	
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
		addC(panel, 0, 2, 1, 1);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}
	
	private void removeVariablePanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}
	
	private void addStaticPanels() {
		cmp = new ServerMenuPanel(this);
		ctb = new ServerTaskBar(this, "SERVER");
		csb = new ServerStatusBar(this);
		current_panel = new ServerConnectionPanel(this, "PLACEHOLDER");
		
		addC(ctb, 0, 0, 1, 1);
		addC(cmp, 0, 1, 1, 1);
		addC(current_panel, 0, 2, 1, 1);
		addC(csb, 0, 3, 1, 1);
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight) {
		c.gridx = gridx; c.gridy = gridy;
		c.gridwidth = gridwidth; c.gridheight = gridheight;
		this.add(comp, c);
		this.validate();
	}

	private void setDefaultProperties() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           
        }
		this.getContentPane().setBackground(ServerPanelTemplate.barColor);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(frameSize);
		this.setUndecorated(true);
		this.setLayout(new GridBagLayout());
		this.getContentPane().setBackground(ServerPanelTemplate.barColor);
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
