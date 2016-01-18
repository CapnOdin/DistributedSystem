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
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogNyBruger extends JDialog implements ActionListener,MouseListener {
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private DialogLogin DLogin;
	private JLabel JLOpret, JLNavn, JLKodeord, JLGentagKodeord;
	private JTextField JTBrugernavn;
	private JPasswordField Kodeord, GentagKodeord;
	private JButton JBGem, JBAnnuller;
	private JPanel panel = new JPanel(new GridBagLayout());
	private boolean loggedIn = false;
    private Insets normalInsets = new Insets(2,2,2,2);
    private Insets biggerInsets = new Insets(10,0,0,0);
    private String brugernavn, kodeord, newUser, gentagKodeord;
    
    private DialogLogin Dlogin;
    private DialogKodeordIkkeEns DKodeordIkkeEns;

	public DialogNyBruger(MainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;	
		addC(JLOpret,0,i,1);i++;  c.insets = biggerInsets;
		addC(JLNavn,0,i,1); i++;
		addC(JTBrugernavn,0,i,2); i++; c.insets = normalInsets;
		addC(JLKodeord,0,i,1); i++;
		addC(Kodeord,0,i,2); i++;
		addC(JLGentagKodeord,0,i,1); i++;
		addC(GentagKodeord,0,i,2);i++;
		addC(JBGem,0,i,1); 
		addC(JBAnnuller,1,i,1);
		
		GentagKodeord.addActionListener(this);
		JBGem.addMouseListener(this);
		JBAnnuller.addMouseListener(this);
		
		this.add(panel);
		this.pack();
		this.setModal(true);

	}

	private void addC(JComponent comp, int x, int y, int width){
    	c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c);
		panel.validate();
    }
	
	private void setJTextField(JTextField name) {
		name.setFont(new Font("SansSerif", Font.ITALIC, 14));
		name.setVisible(true);
	}

	private void setJLabel(JLabel name) {
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);
	}

	private void setJButton(JButton name) {
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);
	}

	private void setJComponents() {
		JLOpret = new JLabel("<HTML><U>Opret Ny Bruger</U></HTML>");
		JLNavn = new JLabel("Ønskede Brugernavn");
		JLKodeord = new JLabel("Kodeord");
		JLGentagKodeord = new JLabel("Gentag Kodeord");
		JTBrugernavn = new JTextField(20);
		Kodeord = new JPasswordField(20);
		GentagKodeord = new JPasswordField(20);
		JBGem = new JButton("Gem");
		JBAnnuller = new JButton("Annuller");
		JLOpret.setFont(new Font("SansSerif",Font.PLAIN,25));
		setJLabel(JLNavn);
		setJLabel(JLKodeord);
		setJLabel(JLGentagKodeord);
		setJTextField(JTBrugernavn);
		setJTextField(Kodeord);
		setJTextField(GentagKodeord);
		setJButton(JBGem);
		setJButton(JBAnnuller);
	}
	
	private String getNewUser(){
		brugernavn = JTBrugernavn.getText();
		newUser = "A10." + brugernavn + "." + kodeord;
		return newUser;
	}
	
	private boolean getNyeKodeordOK(){
		kodeord = Kodeord.getText();
		gentagKodeord = GentagKodeord.getText();
		return kodeord.equals(gentagKodeord);
	}

	private void setDefaultProperties() {
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(500,300));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBGem){
			makeNewUser();
		}
		if (e.getSource() == JBAnnuller){
			this.setVisible(false);
			DLogin = new DialogLogin(parent);
			DLogin.setAlwaysOnTop(true);
			DLogin.setVisible(true);		
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GentagKodeord){
			makeNewUser();
		}
	}
	
	public void makeNewUser(){
		if(getNyeKodeordOK()){
			MainFrame.client.sendMessage(getNewUser());
			dispose();
			DLogin = new DialogLogin(parent);
			DLogin.setAlwaysOnTop(true);
			DLogin.setVisible(true);
		}
		else{
			DKodeordIkkeEns = new DialogKodeordIkkeEns(parent);
			DKodeordIkkeEns.setAlwaysOnTop(true);
			DKodeordIkkeEns.setVisible(true);
		}
	}
}
