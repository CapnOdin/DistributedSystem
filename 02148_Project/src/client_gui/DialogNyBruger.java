package client_gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogNyBruger extends JDialog implements ActionListener,MouseListener {
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel JLNavn, JLKodeord, JLGentagKodeord;
	private JTextField JTNavn;
	private JPasswordField Kodeord, GentagKodeord;
	private JButton JBGem, JBAnnuller;

	public DialogNyBruger(MainFrame parent) {
		super(parent, "Login", true);
		setDefaultProperties();
		setJComponents();
		int i = 0;
		addC(JLNavn,0,i,1); i++;
		addC(JTNavn,0,i,2); i++;
		addC(JLKodeord,0,i,1); i++;
		addC(Kodeord,0,i,2); i++;
		addC(JLGentagKodeord,0,i,1); i++;
		addC(GentagKodeord,0,i,2);i++;
		addC(JBGem,0,i,1);
		addC(JBAnnuller,0,i,1);
		
		pack();
        setResizable(false);
        setLocationRelativeTo(parent);
	}

	private void addC(JComponent comp, int x, int y, int width){
    	c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		this.add(comp, c);
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
		JLNavn = new JLabel("Brugernavn");
		JLKodeord = new JLabel("Kodeord");
		JLGentagKodeord = new JLabel("Gentag Kodeord");
		JTNavn = new JTextField(20);
		Kodeord = new JPasswordField(20);
		GentagKodeord = new JPasswordField(20);
		JBGem = new JButton("Gem");
		JBAnnuller = new JButton("Annuller");
		setJLabel(JLNavn);
		setJLabel(JLKodeord);
		setJLabel(JLGentagKodeord);
		setJTextField(JTNavn);
		setJTextField(Kodeord);
		setJTextField(GentagKodeord);
		setJButton(JBGem);
		setJButton(JBAnnuller);
	}

	private void setDefaultProperties() {
		this.setUndecorated(true);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500, 200));
		this.setLayout(new GridBagLayout());
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
