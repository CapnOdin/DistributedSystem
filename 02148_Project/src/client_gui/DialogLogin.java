package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import server_eng.TCPServer;
import client_eng.TCPClient;


public class DialogLogin extends JDialog implements ActionListener, MouseListener{
	private MainFrame parent;
    private GridBagConstraints c = new GridBagConstraints();
	private JTextField JTBrugernavn;
    private JPasswordField Kodeord;
    private JLabel JLLogin, JLBrugernavn, JLKodeord, JLNyBruger;
    private JButton JBLogin, JBAnnuller;
    private JPanel panel = new JPanel(new GridBagLayout());
    private Insets normalInsets = new Insets(2,2,2,2);
    private Insets biggerInsets = new Insets(10,2,2,2);
    private String info, brugernavn, kodeord, authentication, sessionID;
    
    private DialogNyBruger DNyBruger;
    private DialogForkertLogin DForkertLogin;

    
    
    public DialogLogin(MainFrame parent) {
        this.parent = parent;
        setDefaultProperties();
        setJComponents();      
        
        int i = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        addC(JLLogin,0,i,1);i++; c.insets = biggerInsets;
        addC(JLBrugernavn, 0,i,1);i++;c.insets = biggerInsets;
        addC(JTBrugernavn,0,i,2);i++;
        addC(JLKodeord,0,i,1);i++;
        addC(Kodeord,0,i,2);i++; c.insets = biggerInsets;
        addC(JLNyBruger,0,i,1);i++; c.insets = normalInsets;
        addC(JBLogin,0,i,1);
        addC(JBAnnuller,1,i,1);
        this.add(panel);
        
        Kodeord.addActionListener(this);
        JBLogin.addMouseListener(this);
        JLNyBruger.addMouseListener(this);
        JBAnnuller.addMouseListener(this);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    private void addC(JComponent comp, int x, int y, int width){
    	c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c);
    }
    
    private void setJTextField(JTextField name){
		name.setFont(new Font("SansSerif", Font.ITALIC, 14));
		name.setVisible(true);		
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJComponents(){
		JLLogin = new JLabel("<HTML><U>Log ind</U></HTML>");
		JLLogin.setFont(new Font("SansSerif",Font.PLAIN,25));
        JLBrugernavn = new JLabel("Brugernavn: ");
        JTBrugernavn = new JTextField(20);
        JLKodeord = new JLabel("Kodeord: ");
        Kodeord = new JPasswordField(20);
        JBLogin = new JButton("Log ind");
        JLNyBruger = new JLabel("<HTML><U>Opret Ny bruger</U></HTML>");
        JLNyBruger.setForeground(Color.blue);
        JBAnnuller = new JButton("Annuller");
        setJTextField(JTBrugernavn);
        setJTextField(Kodeord);
        setJLabel(JLBrugernavn);
        setJLabel(JLKodeord);
        setJButton(JBLogin);
        setJLabel(JLNyBruger);
        setJButton(JBAnnuller);
	}
	
    private void setDefaultProperties(){
    	this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
    	this.setUndecorated(true);
    	this.setPreferredSize(new Dimension(500,300));
    }
    
    private String getAuthentication(){
    	authentication = "Lise.projekt"; //Senere: Hent authentication direkte fra server
    	return authentication;
    }
    
    private String getInfo(){
    	brugernavn = JTBrugernavn.getText();
    	kodeord = Kodeord.getText();
    	sessionID = MainFrame.client.getSessionID();
    	info = "A0." + brugernavn + "." + kodeord + "." + sessionID;
    	return info;
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == Kodeord){
			login();
			
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBLogin){
			login();
		}
		if (e.getSource() == JLNyBruger){	
			this.setVisible(false);
			DNyBruger = new DialogNyBruger(parent);
			DNyBruger.setAlwaysOnTop(true);
			DNyBruger.setVisible(true);
		}
		if (e.getSource() == JBAnnuller){
			System.exit(0);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	private void login(){
        MainFrame.client.sendMessage(getInfo());
		this.setContentPane(new JLabel(new ImageIcon("load.gif")));
			if(parent.stallGUI("A0","TRUE")){
				MainFrame.profile.username = brugernavn;
				MainFrame.profile.password = kodeord;
				MainFrame.panel2.p3Data.setField();
            	this.setVisible(false);
            	parent.mainFrameSetVisible();
            	TaskBar.addForbundet();
            	dispose();
            	
            	
			} 
			else {
        		this.setVisible(false);
        		DForkertLogin = new DialogForkertLogin(parent);
        		DForkertLogin.setAlwaysOnTop(true);
        		DForkertLogin.setVisible(true);
			
        	}
	}
}
