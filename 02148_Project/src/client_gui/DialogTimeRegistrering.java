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
	private JTextField JTNavn, JTStartts, JTSluttid, JTPause;
	
	public DialogTimeRegistrering(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
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
		
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
