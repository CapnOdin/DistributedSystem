package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerConnectionDialog extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private ServerMainFrame parent;
	private JPanel dialogContentpane = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();

	private JPanel buttonHolder = new JPanel(new GridLayout());
	private JLabel portLabel = new JLabel("Port: ", JLabel.LEFT);
	private JTextField portField = new JTextField(15);
	private JButton[] buttons = new JButton[2];

	public ServerConnectionDialog(ServerMainFrame parent) {
		this.parent = parent;
		setDialogProperties();
		setContentProperties();
		setElementProperties();
		addElements();
	}

	private void addElements() {
		
		addC(portLabel, 0, 0, 1, 0);
		addC(portField, 1, 0, 1, 0);
		addC(new JLabel(), 0, 1, 2, 7);
		addC(buttonHolder, 0, 2, 2, 0);
		
		this.add(dialogContentpane);
		this.validate();
	}

	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int ipady) {
		c.ipady = ipady;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.fill = GridBagConstraints.HORIZONTAL;
		dialogContentpane.add(comp, c);
		dialogContentpane.validate();
	}

	private void setElementProperties() {
		for (int i = 0; i < 2; i++) {
			buttons[i] = new JButton();
			buttons[i].setVisible(true);
			buttons[i].addActionListener(this);
			buttons[i].addMouseListener(this);
			buttons[i].setBackground(Color.white);
			buttonHolder.add(buttons[i]);
		}

		buttonHolder.setVisible(true);
		dialogContentpane.setBackground(Color.white);
		portField.setVisible(true);

		// NAMING ELEMENTS
		buttons[0].setText("Start");
		buttons[1].setText("Cancel");
	}

	private void setContentProperties() {
		dialogContentpane.setVisible(true);
	}

	private void setDialogProperties() {
		parent.setGlassPane(new ServerBlurGlass(parent));
		parent.setFocusable(false);
		parent.getGlassPane().setVisible(true);
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(300,100));
		this.getContentPane().setBackground(Color.white);
		this.setAlwaysOnTop(true);
		this.getRootPane().setBackground(Color.white);
		this.getRootPane().setBorder(BorderFactory.createTitledBorder("Setup Server"));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == buttons[0]) {
			System.out.println("Connect pressed");
			ServerMainFrame.portNumber = Integer.parseInt(portField.getText());
			ServerMainFrame.setupServer();
			this.setVisible(false);
			parent.getGlassPane().setVisible(false);
			parent.setFocusable(true);
		}
		
		if(e.getSource() == buttons[1]) {
			System.out.println("Cancel pressed.");
			this.setVisible(false);
			parent.getGlassPane().setVisible(false);
			parent.setFocusable(true);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
