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

public class DialogKodeordSkiftet extends JDialog implements ActionListener, MouseListener {
	
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLKodeordSkiftet;
	private JButton JBOK;
	
	private DialogBesked DBesked;
	
	public DialogKodeordSkiftet(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		c.ipady = 50;
		addC(JLKodeordSkiftet,0,0,1);
		c.ipady = 0;
		addC(JBOK,0,1,1);
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
		JLKodeordSkiftet = new JLabel("<HTML><U>Forkert Kodeord</U></HTML>");
		JLKodeordSkiftet.setFont(new Font("SanSerif",Font.PLAIN,25));
		JLKodeordSkiftet.setVisible(true);
		JBOK = new JButton("Prøv igen");
		JBOK.setFont(new Font("SanSerif",Font.PLAIN,14));
		JBOK.setVisible(true);
		JBOK.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBOK){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
