package client_gui;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;

public class DialogTimeRegistrering extends JDialog implements ActionListener, MouseListener{
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel JLNavn, JLStarttid, JLSluttid,JLPause;
	private JTextField JTNavn, JTStarttid, JTSluttid, JTPause;
	private JButton JBGem;
	private String starttid, sluttid, pause;
	
	public DialogTimeRegistrering(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		int i = 0;
		addC(JLNavn,i,0,1);
		addC(JTNavn,i,1,1);i++;
		addC(JLStarttid,i,0,1);
		addC(JTStarttid,i,1,1);i++;
		addC(JLSluttid,i,0,1);
		addC(JTSluttid,i,1,1);i++;
		addC(JLPause,i,0,1);
		addC(JTPause,i,1,1);
		addC(JBGem,i,3,1);
		
		this.add(panel);
		pack();
	    setResizable(false);
	    setLocationRelativeTo(parent);
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(500,300));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void setJComponents(){
		JLNavn = new JLabel("Opgave Navn");
		JLStarttid = new JLabel("Starttid");
		JLSluttid = new JLabel("Sluttid");
		JLPause = new JLabel("Pause");
		JTNavn = new JTextField(10);
		JTStarttid = new JTextField(4);
		JTSluttid = new JTextField(4);
		JTPause = new JTextField("0");
		JBGem = new JButton("Gem");
		JBGem.addMouseListener(this);
		JTPause.addActionListener(this);
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c);
	}
	
	private String getJob(){
		starttid = JTStarttid.getText();
		sluttid = JTSluttid.getText();
		pause = JTPause.getText();
		return "A14." + starttid + "." + sluttid + "." + pause + "."+ MainFrame.client.getSessionID();
	}
	
	private void addJob(){
		getJob();
		if (!starttid.isEmpty() && !sluttid.isEmpty() && !pause.isEmpty()){
			MainFrame.client.sendMessage(getJob());
			if (parent.stallGUI("A7", "TRUE")){
				DialogBesked DBesked = new DialogBesked(parent, "Timer registreret");
				DBesked.setAlwaysOnTop(true);
				DBesked.setVisible(true);
				dispose();
			}
			else{
				DialogBesked DBesked = new DialogBesked(parent, "Timer ikke registreret");
				DBesked.setAlwaysOnTop(true);
				DBesked.setVisible(true);
			}
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBGem){
			addJob();
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
		if (e.getSource() == JTPause){
			addJob();
		}
		
	}

}
