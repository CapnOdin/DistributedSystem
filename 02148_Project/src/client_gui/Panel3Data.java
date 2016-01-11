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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
		int JTWidth = frameSizePanel3.width/2;
		int spaceLeft = 100;
		int spaceTop = spaceLeft;
		int spaceMiddle = 40;
		int JPWidth = frameSizePanel3.width/6;
		int spaceRight = frameSizePanel3.width - spaceLeft - JTWidth - spaceMiddle - JPWidth;
		//int spaceButtom = frameSizePanel3.height - spaceTop -
		
		//Panel 1 - Insets = Top, Venstre, Bund, Højre
		int i = 0;
		gbc.anchor = GridBagConstraints.NORTHWEST;	
		addC(JLPersonlig,	0,	i,	1,	1,	0,			new Insets(spaceTop,	spaceLeft,	2,		spaceMiddle));i++;
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		addC(JLNavn,		0,	i,	1,	1,	0, 			new Insets(40,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTNavn,		0,	i,	1,	1,	JTWidth, 	new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLAdresse,		0,	i,	1,	1,	0, 			new Insets(20,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTAdresse,		0,	i,	1,	1,	JTWidth, 	new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLPostnummer,	0,	i,	1,	1,	0,			new Insets(4,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTPostnummer,	0,	i,	1,	1,	JTWidth/3, 	new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLBy,			0,	i,	1,	1,	0, 			new Insets(4,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTBy,			0,	i,	1,	1,	JTWidth, 	new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JCHarBil,		0,	i,	1,	1,	0, 			new Insets(20,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JBGem,			0,	i,	1,	1,	0, 			new Insets(2,			spaceLeft,	200,	spaceMiddle));i++;
		
		
		//Panel 2
		gbc.ipady = frameSizePanel3.height/2;
		gbc.anchor = GridBagConstraints.NORTH;	
		addC(JLBillede,		1,	1,	1,	10,	JPWidth, 	new Insets(40,	2,	100,	spaceRight));	
		//addC(JLSkiftBillede,1,	10,	1,	1,	0, 		new Insets(spaceTop;	2,	2,	spaceRight));
		
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
	/*
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSize);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel3Data());
		test.validate();
	}
	*/
}
