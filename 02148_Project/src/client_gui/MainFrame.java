package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;

import client_eng.TCPClient;

public class MainFrame extends JFrame implements GeneralProperties {
	private GridBagConstraints c = new GridBagConstraints();
	private TaskBar taskBar;
	private Panel2 panel2;
	private PanelTemplate vistPanel3,vistPanel1;
	private String ip;
	private int port;
	
	private DialogLogin DLogin;
	private DialogNyBruger DNyBruger;
	
	public static TCPClient client;


	public MainFrame() {
		ip = "localhost";
		port = 1234;
		client =  new TCPClient(ip, port, "Lise");
		client.start();
		DLogin = new DialogLogin(this);
		DLogin.setAlwaysOnTop(true);
	    DLogin.setVisible(true);		
	    setDefaultProperties();
		taskBar = new TaskBar(this);
		vistPanel1 = new Panel1(this);
		panel2 = new Panel2(this);
		vistPanel3 = new Panel3Data(this);
		addC(taskBar, 0, 0, 1, 1);
		addC(vistPanel1, 0, 1, 1, 1);
		addC(panel2, 0, 2, 1, 1);
		addC(vistPanel3, 0, 3, 1, 1);
		this.validate();;
		//mainFrameSetVisible();
		
	}

	public void removePanel() {
		this.vistPanel3.setVisible(false);
		this.validate();
		this.pack();
	}

	public void addPanel(PanelTemplate panel) {
		removePanel();
		vistPanel3 = panel;
		addC(panel, 0, 3, 1, 1);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}
	
	

	private void addC(JComponent comp, int x, int y, int height, int width) {
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
		this.add(comp, c);
	}

	private void setDefaultProperties() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           
        }
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setUndecorated(true);
		this.getContentPane().setBackground(Color.white);
		//this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(GeneralProperties.frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void mainFrameSetVisible(){
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
