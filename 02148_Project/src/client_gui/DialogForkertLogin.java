package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogForkertLogin extends JDialog implements MouseListener {
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLUgyldig, JLNyBruger;
	private JButton JBPrøvIgen, JBGlemtKodeord;
	
	private DialogNyBruger DNyBruger;
	private DialogLogin DLogin;
	
	public DialogForkertLogin(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		int i = 0;
		c.anchor = GridBagConstraints.CENTER;
		addC(JLUgyldig,0,i,2); i++; c.insets = new Insets(20,2,2,2);
		addC(JLNyBruger,0,i,2);i++;c.insets = new Insets(2,2,2,2);
		addC(JBPrøvIgen,0,i,1);
		addC(JBGlemtKodeord,1,i,1);
		
		JLNyBruger.addMouseListener(this);
		JBPrøvIgen.addMouseListener(this);
		JBGlemtKodeord.addMouseListener(this);
		
		this.add(panel);
		this.pack();
		this.setModal(true);
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c);
	}
	
	private void setDefaultProperties(){
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(500,200));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SanSerif",Font.PLAIN,14));
		name.setVisible(true);
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SanSerif",Font.PLAIN,14));
		name.setVisible(true);
	}
	
	private void setJComponents(){
		JLUgyldig = new JLabel("<HTML><U>Ugyldigt login!</U></HTML>");
		JLUgyldig.setFont(new Font("SanSerif", Font.PLAIN, 25));
		JLNyBruger = new JLabel("<HTML><U>Opret Ny bruger</U></HTML>");
		JLNyBruger.setForeground(Color.blue);
		JBPrøvIgen = new JButton("Prøv igen");
		JBGlemtKodeord = new JButton("Glemt Kodeord");
		setJLabel(JLNyBruger);
		setJButton(JBPrøvIgen);
		setJButton(JBGlemtKodeord);		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JLNyBruger){
			this.setVisible(false);
			DNyBruger = new DialogNyBruger(parent);
			DNyBruger.setAlwaysOnTop(true);
			DNyBruger.setVisible(true);
		}
		if (e.getSource() == JBPrøvIgen) {
			this.setVisible(false);
			DLogin = new DialogLogin(parent);
			DLogin.setAlwaysOnTop(true);
			DLogin.setVisible(true);
		}
		if (e.getSource() == JBGlemtKodeord){
			System.exit(0);
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
