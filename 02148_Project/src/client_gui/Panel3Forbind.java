package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel3Forbind extends PanelTemplate implements GeneralProperties{
	private MainFrame parent;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail, JTKodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	
	public Panel3Forbind(MainFrame parent){
		this.parent = parent;
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setVisible(true);
		this.add(panel);
		JLForbind = new JLabel("Forbind bruger med Moment konto");
		JLEMail = new JLabel("E-Mail");
		JLKodeord = new JLabel("Kodeord");
		JTEMail = new JTextField();
		JTKodeord = new JTextField();
		JCGemOplysninger = new JCheckBox("Gem oplysninger");
		JBForbind = new JButton("Forbind");
		JLForbind.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLForbind.setVisible(true);
		setJLabel(JLEMail);
		setJLabel(JLKodeord);
		setJTextField(JTEMail);
		setJTextField(JTKodeord);
		setJCheckBox(JCGemOplysninger);
		setJButton(JBForbind);
		
		// Insets = Top, Venstre, Bund, Højre
		gbc.anchor = GridBagConstraints.NORTHWEST;
		addC(JLForbind,			0,	0,	1,	1,	0,		new Insets(80,	2,	2,	2));
		addC(JLEMail,			0,	1,	1,	1,	0,		new Insets(20,	2,	2,	2));
		addC(JTEMail,			0,	2,	1,	1,	300,	new Insets(2,	2,	2,	2));
		addC(JLKodeord,			0,	3,	1,	1,	0,		new Insets(10,	2,	2,	2));
		addC(JTKodeord,			0,	4,	1,	1,	300,	new Insets(2,	2,	2,	2));
		addC(JCGemOplysninger,	0,	5,	1,	1,	0,		new Insets(20,	2,	2,	2));
		addC(JBForbind,			0,	6,	1,	1,	0,		new Insets(2,	2,	100,2));
		this.setVisible(true);
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizePanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, int width, Insets space) {
		gbc.insets = space;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.ipadx = width;
		this.add(comp, gbc);
		this.validate();
	}
	
	private void setJTextField(JTextField name){
		name.setFont(new Font("SansSerif", Font.ITALIC, 14));
		name.setVisible(true);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJCheckBox(JCheckBox name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println(frameSizePanel3);
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel3Connect());
		test.validate();
	}
}
