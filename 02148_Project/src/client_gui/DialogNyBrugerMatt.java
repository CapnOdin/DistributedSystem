package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class DialogNyBrugerMatt extends JDialog implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Dimension dialogSize = new Dimension(500,200);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private JPanel contentpane = new JPanel(new GridBagLayout());
	private JPanel buttonHolder = new JPanel(new GridLayout());
	private JLabel[] labels = new JLabel[3];
	private JPasswordField[] passwords = new JPasswordField[2];
	private JTextField usernameField = new JTextField(20);
	private JButton[] buttons = new JButton[2];
	
	private Font myFont = new Font("SansSerif", Font.PLAIN, 14);
	private Font myItalicFont = new Font("SansSerif", Font.ITALIC, 14);
	
	private MainFrame parent;
	
	public DialogNyBrugerMatt(MainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		setElementProperties();
		addElements();
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int ipadx, int gridwidth) {
		c.gridx = gridx; c.gridy = gridy; c.ipadx = ipadx; c.fill = GridBagConstraints.HORIZONTAL;
		contentpane.add(comp, c);
		contentpane.validate();
	}

	private void addElements() {
		
		addC(labels[0], 0, 0, 20, 1);
		addC(usernameField, 1, 0, 0, 1);
		
		addC(labels[1], 0, 1, 20, 1);
		addC(passwords[0], 1, 1, 0, 1);
		
		addC(labels[2], 0, 2, 20, 1);
		addC(passwords[1], 1, 2, 0, 1);
	
		addC(buttonHolder, 0, 3, 0, 2);
		
		this.add(contentpane);
		this.pack();
		this.setModal(true);
	}

	private void setElementProperties() {
		for(int i = 0; i < 2; i++) {
			passwords[i] = new JPasswordField(20);
			passwords[i].setFont(myFont);
			passwords[i].setVisible(true);
			
			buttons[i] = new JButton();
			buttons[i].setFont(myFont);
			buttons[i].setVisible(true);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.white);
			buttonHolder.add(buttons[i]);
		}
		
		for(int i = 0; i < 3; i++) {
			labels[i] = new JLabel("", JLabel.LEFT);
			labels[i].setFont(myFont);
			labels[i].setVisible(true);
		}
		
		buttonHolder.setVisible(true);
		contentpane.setBackground(Color.white);
		usernameField.setFont(myItalicFont);
		usernameField.setVisible(true);
		
		// NAMING ELEMENTS
		buttons[0].setText("Gem");
		buttons[1].setText("Annuller");
		
		labels[0].setText("Brugernavn");
		labels[1].setText("Kodeord");
		labels[2].setText("Gentag Kodeord");
		
	}

	private void setDefaultProperties() {
		this.setUndecorated(true);
		this.setPreferredSize(dialogSize);
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]) {
			System.out.println("Gem pressed.");
		}
		
		if(e.getSource() == buttons[1]) {
			System.out.println("Annuller pressed.");
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
