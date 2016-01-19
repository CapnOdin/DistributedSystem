package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DialogBesked extends JDialog implements GeneralProperties, MouseListener, ActionListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLBesked,JLSamkorsel;
	private JButton JBOK, JBSend, JBLuk, JBProvIgen,JBProvIgen1;
	private JTextField JTSendBesked;
	private JTextArea JTAChat;
	
	private DialogLogin DLogin;
	
	public DialogBesked(MainFrame parent, String message){
		this.parent = parent;
		
		setJComponents(message);
		if (message == "Kodeord ikke ens"){
			this.setPreferredSize(new Dimension(400,150));
			c.ipady = 50;
			addC(JLBesked,0,0,1);
			c.ipady = 0;
			addC(JBProvIgen1,0,1,1);
			this.add(panel);
		}
		else if (message == "Ønskede brugernavn i brug"){
			this.setPreferredSize(new Dimension(400,150));
			c.ipady = 50;
			addC(JLBesked,0,0,1);
			c.ipady = 0;
			addC(JBProvIgen1,0,1,1);
			this.add(panel);
		}
		else if (message == "Nuværende kodeord forkert" ){

			this.setPreferredSize(new Dimension(400,150));
			c.ipady = 50;
			addC(JLBesked,0,0,1);
			c.ipady = 0;
			addC(JBProvIgen,0,1,1);
			this.add(panel);
		}
		else if (message == "Nye Kodeord ikke ens"){

			this.setPreferredSize(new Dimension(400,150));
			c.ipady = 50;
			addC(JLBesked,0,0,1);
			c.ipady = 0;
			addC(JBProvIgen,0,1,1);
			this.add(panel);
		}
		else if (message == "Chat"){
			this.setPreferredSize(new Dimension(400,400));
			addC(JLSamkorsel,0,0,5);
			addC(JTAChat,0,1,5);
			addC(JTSendBesked,0,2,4);
			c.fill = GridBagConstraints.HORIZONTAL;
			addC(JBSend,4,2,1);			
			addC(JBLuk,0,3,5);
			this.add(panel);
		}
		else {
			this.setPreferredSize(new Dimension(400,150));
			c.ipady = 50;
			addC(JLBesked,0,0,1);
			c.ipady = 0;
			addC(JBOK,0,1,1);
			this.add(panel);
		}
		
		setDefaultProperties();
		this.pack();
		this.setVisible(true);
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp,c);
	}
	
	private void setJComponents(String msg){
		JLBesked = new JLabel(msg);
		setJLabel(JLBesked);
		JLSamkorsel = new JLabel("Væg: Arranger fælles kørsel");
		setJLabel(JLSamkorsel);
		JBProvIgen1 = new JButton("Prøv igen");
		JBProvIgen = new JButton("Prøv igen");
		JBOK = new JButton("OK");
		JBSend = new JButton("Send");
		JBLuk = new JButton("Luk");
		JTSendBesked = new JTextField(25);
		JTSendBesked.addActionListener(this);
		JTAChat = new JTextArea();
		JTAChat.setPreferredSize(new Dimension(380,300));
		JTAChat.setBorder(BorderFactory.createLineBorder(Color.black));
		JTAChat.setEditable(false);
		setJButton(JBProvIgen1);
		setJButton(JBProvIgen);
		setJButton(JBOK);
		setJButton(JBSend);
		setJButton(JBLuk);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SanSerif",Font.PLAIN,25));
		name.setVisible(true);
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SanSerif",Font.PLAIN,14));
		name.addMouseListener(this);
		name.setVisible(true);
	}
	
	private void sendBesked(){
		String besked = JTSendBesked.getText();
		JTAChat.append(besked+ "\n");
		JTSendBesked.setText(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBProvIgen){
			dispose();
			DialogSkiftKodeord DSkiftKodeord= new DialogSkiftKodeord(parent);
			DSkiftKodeord.setAlwaysOnTop(true);
			DSkiftKodeord.setVisible(true);
		}
		if (e.getSource() == JBOK){
			dispose();
		}
		if (e.getSource() == JBSend){
			sendBesked();
		}
		if (e.getSource() == JBLuk){
			dispose();
		}
		if (e.getSource() == JBProvIgen1){
			dispose();
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
		if (e.getSource() == JTSendBesked){
			sendBesked();
		}
		
	}
}
