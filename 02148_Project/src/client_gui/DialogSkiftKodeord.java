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
import javax.swing.JTextField;

public class DialogSkiftKodeord extends JDialog implements ActionListener, MouseListener {
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel JLSkiftKodeord, JLNuværendeKodeord, JLNyeKodeord, JLGentagKodeord;
	private JTextField JTNuværendeKodeord, JTNyeKodeord, JTGentagKodeord;
	private JButton JBGem, JBAnnuller;
	
	public DialogSkiftKodeord(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
		addC(JLSkiftKodeord, 0, i, 1);i++; c.insets = new Insets(20,2,2,2);
		addC(JLNuværendeKodeord,0,i,1);i++; c.insets = new Insets(2,2,2,2);
		addC(JTNuværendeKodeord,0,i,2);i++;
		addC(JLNyeKodeord,0,i,1);i++;
		addC(JTNyeKodeord,0,i,2);i++;
		addC(JLGentagKodeord,0,i,1);i++;
		addC(JTGentagKodeord,0,i,2);i++;
		addC(JBGem,0,i,1);
		addC(JBAnnuller,1,i,1);
		
		JTGentagKodeord.addActionListener(this);
		JBGem.addMouseListener(this);
		JBAnnuller.addMouseListener(this);
		
		this.add(panel);
		this.pack();
		this.setModal(true);
		
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(500,300));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c );
	}
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif",Font.PLAIN,14));
		name.setVisible(true);
	}
	
	private void setJTextField(JTextField name){
		name.setFont(new Font("SansSerif",Font.PLAIN,14));
		name.setVisible(true);
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SansSerif",Font.PLAIN,14));
		name.setVisible(true);
	}
	
	private void setJComponents(){
		JLSkiftKodeord = new JLabel("<HTML><U>Skift Kodeord</U></HTML>");
		JLSkiftKodeord.setFont(new Font("SanfSerif", Font.PLAIN,25));
		JLNuværendeKodeord = new JLabel("Nuværende Kodeord");
		JLNyeKodeord = new JLabel("Nyt Kodeord");
		JLGentagKodeord = new JLabel("Gentag Kodeord");
		JTNuværendeKodeord = new JTextField(20);
		JTNyeKodeord = new JTextField(20);
		JTGentagKodeord = new JTextField(20);
		JBGem = new JButton("Gem");
		JBAnnuller = new JButton("Annuller");
		setJLabel(JLNuværendeKodeord);
		setJLabel(JLNyeKodeord);
		setJLabel(JLGentagKodeord);
		setJTextField(JTNuværendeKodeord);
		setJTextField(JTNyeKodeord);
		setJTextField(JTGentagKodeord);
		setJButton(JBGem);
		setJButton(JBAnnuller);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBGem){
			dispose();
		}
		if ( e.getSource() == JBAnnuller){
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
		if (e.getSource() == JTGentagKodeord){
			dispose();
		}
		
	}
}
