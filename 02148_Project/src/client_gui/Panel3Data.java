package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel3Data extends PanelTemplate implements GeneralProperties{
	private GridBagConstraints gbc = new GridBagConstraints();
	private MainFrame parent;
	private JTextField JTNavn, JTAdresse, JTPostnummer, JTBy;
	private JLabel JLPersonlig, JLNavn, JLAdresse, JLBillede, JLPostnummer, JLBy, JLSkiftBillede;
	private JButton JBGem;
	private JCheckBox JCHarBil;
	
	public Panel3Data(MainFrame parent){
		System.out.println(frameSizePanel3);
		this.parent = parent;
		JPanel panel = new JPanel();
		this.add(panel);
		JTNavn = new JTextField();
		JTAdresse = new JTextField();
		JTPostnummer = new JTextField();
		JTBy = new JTextField();
		JLPersonlig = new JLabel("Personlig profil");
		JLPersonlig.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLNavn = new JLabel("Navn");
		JLAdresse = new JLabel("Adresse");
		JLPostnummer = new JLabel("Postnummer");
		JLBy = new JLabel("By");
		JLSkiftBillede = new JLabel("Skift billede");
		JCHarBil = new JCheckBox("Har bil");
		JBGem = new JButton("Gem");	
		JLBillede = new JLabel("Billede", SwingConstants.CENTER);
		setJTextField(JTNavn);
		setJTextField(JTAdresse);
		setJTextField(JTPostnummer);
		setJTextField(JTBy);
		setJLabel(JLNavn);
		setJLabel(JLAdresse);
		setJLabel(JLPostnummer);
		setJLabel(JLBy);
		setJLabel(JLSkiftBillede);
		setJCheckBox(JCHarBil);
		setJButton(JBGem);
		setJLabel(JLBillede);
		JLBillede.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//Panel 1 - Insets = Top, Venstre, Bund, Højre
		gbc.anchor = GridBagConstraints.NORTHWEST;	
		addC(JLPersonlig,	0,	0,	1,	1,	0,		new Insets(2,80,20,20));
		addC(JLNavn,		0,	1,	1,	1,	0, 		new Insets(2,80,2,20));
		addC(JTNavn,		0,	2,	1,	1,	300, 	new Insets(2,80,30,20));
		addC(JLAdresse,		0,	3,	1,	1,	0, 		new Insets(2,80,2,20));
		addC(JTAdresse,		0,	4,	1,	1,	300, 	new Insets(2,80,2,2));
		addC(JLPostnummer,	0,	5,	1,	1,	0,		new Insets(2,80,2,2));
		addC(JTPostnummer,	0,	6,	1,	1,	100, 	new Insets(2,80,2,2));
		addC(JLBy,			0,	7,	1,	1,	0, 		new Insets(2,80,2,2));
		addC(JTBy,			0,	8,	1,	1,	300, 	new Insets(2,80,2,2));
		addC(JCHarBil,		0,	9,	1,	1,	0, 		new Insets(2,80,2,20));
		addC(JBGem,			0,	10,	1,	1,	0, 		new Insets(2,80,2,2));
		
		
		//Panel 2
		gbc.ipady = 200;
		addC(JLBillede,		1,	1,	1,	9,	100, 	new Insets(2,2,2,2));
		gbc.anchor = GridBagConstraints.CENTER;		
		addC(JLSkiftBillede,1,	8,	1,	1,	100, 	new Insets(2,2,2,2));
		
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
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSize);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel3Data());
		test.validate();
	}
}
