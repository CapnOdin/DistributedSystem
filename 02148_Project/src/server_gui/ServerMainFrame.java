package server_gui;

import java.awt.Color;
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
	private Dimension frameSize = new Dimension(1024,600);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private ServerMenuPanel smp;
	private ServerTaskBar stb;
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
		addC(panel, 0, 2, 1, 1, 0, 100);
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
		stb = new ServerTaskBar(this, "SERVER");
		smp = new ServerMenuPanel(this);
		ssb = new ServerStatusBar(this);
		current_panel = new ServerConnectionPanel(this, "PLACEHOLDER");
		
		addC(stb, 0, 0, 1, 1, this.getWidth()-65, 0);
		addC(smp, 0, 1, 1, 1, 0, 0);
		addC(current_panel, 0, 2, 1, 1, 0, (int)(this.getHeight()*0.877));
		addC(ssb, 0, 3, 1, 1, 0, 0);
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, int ipadx, int ipady) {
		c.gridx = gridx; c.gridy = gridy;
		c.gridwidth = gridwidth; c.gridheight = gridheight;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.fill = GridBagConstraints.BOTH;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(frameSize);
		this.setUndecorated(true);
		this.setLayout(new GridBagLayout());
		this.getContentPane().setBackground(Color.magenta);
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
