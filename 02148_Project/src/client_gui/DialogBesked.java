package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogBesked extends JDialog implements GeneralProperties, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLBesked, JLForkertKodeord;
	private JButton JBOK, JBSend, JBLuk, JBProvIgen;
	
	private DialogLogin DLogin;
	
	public DialogBesked(MainFrame parent, String[] message){
		this.parent = parent;
		setDefaultProperties();
		setJComponents(message[2]);
		if (message[2] == "")
		if (message[0] == "1" ){
			this.setPreferredSize(new Dimension(300,150));
			c.ipady = 50;
			addC(JLForkertKodeord,0,0,1);
			c.ipady = 0;
			addC(JBProvIgen,0,1,1);
			this.add(panel);
		}
		
		
		this.pack();
		this.setVisible(true);
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp,c);
	}
	
	private void setJComponents(String msg){
		JLBesked = new JLabel("<HTML><U>msg</U></HTML>");
		setJLabel(JLBesked);
		JBProvIgen = new JButton("Prøv igen");
		JBOK = new JButton("OK");
		JBSend = new JButton("Send");
		JBLuk = new JButton("Luk");
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBProvIgen){
			this.setVisible(false);
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
}
