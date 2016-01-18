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

public class DialogForkertKodeord extends JDialog implements GeneralProperties, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLForkertKodeord;
	private JButton JBProvIgen;
	
	private DialogLogin DLogin;
	
	public DialogForkertKodeord(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		c.ipady = 50;
		addC(JLForkertKodeord,0,0,1);
		c.ipady = 0;
		addC(JBProvIgen,0,1,1);
		this.add(panel);
		this.pack();
		this.setVisible(true);
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(300,150));
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
	
	private void setJComponents(){
		JLForkertKodeord = new JLabel("<HTML><U>Forkert Kodeord</U></HTML>");
		JLForkertKodeord.setFont(new Font("SanSerif",Font.PLAIN,25));
		JLForkertKodeord.setVisible(true);
		JBProvIgen = new JButton("Prøv igen");
		JBProvIgen.setFont(new Font("SanSerif",Font.PLAIN,14));
		JBProvIgen.setVisible(true);
		JBProvIgen.addMouseListener(this);
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
