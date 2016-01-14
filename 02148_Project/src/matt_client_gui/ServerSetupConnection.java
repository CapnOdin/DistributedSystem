package matt_client_gui;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ServerSetupConnection extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private ClientMainFrame parent;
	private JPanel dialogContentpane = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();

	private JPanel buttonHolder = new JPanel(new GridLayout());
	private JLabel[] labels = new JLabel[3];
	private JPasswordField[] passwords = new JPasswordField[2];
	private JTextField usernameField = new JTextField(20);
	private JButton[] buttons = new JButton[2];

	public ServerSetupConnection(ClientMainFrame parent) {
		this.parent = parent;
		setDialogProperties();
		setContentProperties();
		setElementProperties();
		addElements();
	}

	private void addElements() {
		JLabel loginTitle = new JLabel("", JLabel.CENTER);
		loginTitle.setFont(new Font(loginTitle.getFont().getName(), Font.PLAIN, 14));
		loginTitle.setFont(new Font(loginTitle.getFont().getName(), Font.PLAIN, 12));
		
		addC(loginTitle, 0, 0, 2);
		
		addC(labels[0], 0, 2, 1);
		addC(usernameField, 1, 2, 1);

		addC(labels[1], 0, 3, 1);
		addC(passwords[0], 1, 3, 1);
		
		addC(buttonHolder, 0, 5, 2);
		
		this.add(dialogContentpane);
		this.validate();
		// this.setModal(true);
	}

	private void addC(JComponent comp, int gridx, int gridy, int gridwidth) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.fill = GridBagConstraints.HORIZONTAL;
		dialogContentpane.add(comp, c);
		dialogContentpane.validate();
	}

	private void setElementProperties() {
		for (int i = 0; i < 2; i++) {
			passwords[i] = new JPasswordField(20);
			passwords[i].setVisible(true);

			buttons[i] = new JButton();
			buttons[i].setVisible(true);
			buttons[i].addActionListener(this);
			buttons[i].addMouseListener(this);
			buttons[i].setBackground(Color.white);
			buttonHolder.add(buttons[i]);
		}

		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel("", JLabel.LEFT);
			labels[i].setVisible(true);
		}

		buttonHolder.setVisible(true);
		dialogContentpane.setBackground(Color.white);
		usernameField.setVisible(true);

		// NAMING ELEMENTS
		buttons[0].setText("Connect");
		buttons[1].setText("Cancel");

		labels[0].setText("Username  ");
		labels[1].setText("Password  ");
		labels[2].setText("Confirm Password");

	}

	private void setContentProperties() {
		dialogContentpane.setVisible(true);
	}

	private void setDialogProperties() {
		parent.setGlassPane(new ClientBlurGlass(parent));
		parent.setFocusable(false);
		parent.getGlassPane().setVisible(true);
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(300,100));
		this.getContentPane().setBackground(Color.white);
		this.setAlwaysOnTop(true);
		this.getRootPane().setBackground(Color.white);
		this.getRootPane().setBorder(BorderFactory.createTitledBorder("Login"));
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
			this.getContentPane().removeAll();
			this.setContentPane(new JLabel(new ImageIcon("load.gif")));
			this.pack();
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
