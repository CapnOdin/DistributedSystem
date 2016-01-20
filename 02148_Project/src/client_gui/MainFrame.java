package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import client_eng.Profile;
import client_eng.TCPClient;

public class MainFrame extends JFrame implements GeneralProperties {
	private GridBagConstraints c = new GridBagConstraints();
	private TaskBar taskBar;
	public static Panel2 panel2;
	private JPanel vistPanel3,vistPanel1;
	private String ip;
	private int port;
	public static String[] msg = {""};
	
	private DialogLogin DLogin;
	private DialogNyBruger DNyBruger;
	private DialogBesked DForkertKodeord;
	public DialogSkiftKodeord DSkiftKodeord;
	
	public static TCPClient client;
	public static Profile profile = new Profile();

	public MainFrame() {
		ip = "2.110.0.85";
		//ip = "localhost";
		port = 1234;
		client =  new TCPClient(ip, port);
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

	public void addPanel(JPanel panel) {
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
	
	public boolean stallGUI(String protocol, String value) {
		boolean stall = waitForMsg(protocol, value);
		msg = new String[1];
		msg[0] = "";
		return stall;
	}
	
	private boolean waitForMsg(String protocol, String value){
		int i = 0;
    	while(!msg[0].equals(protocol)){
    		try {
    			if(i > 20){return false;}
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
    	}
    	return msg[1].equals(value);
    }
	
	public void mainFrameSetVisible(){
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
