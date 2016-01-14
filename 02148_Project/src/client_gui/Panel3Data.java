package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel3Data extends PanelTemplate implements GeneralProperties, MouseListener{
	private GridBagConstraints c = new GridBagConstraints();
	private MainFrame parent;
	private JPanel panelLeft = new JPanel(new GridBagLayout());
	private JPanel panelRight = new JPanel();
	private JTextField JTBrugernavn, JTNavn, JTAdresse, JTPostnummer, JTBy;
	private JLabel JLBrugernavn, JLKodeord,JLSkiftKodeord, JLPersonlig, JLNavn, JLAdresse, JLBillede, JLPostnummer, JLBy, JLSkiftBillede;
	private JPasswordField Kodeord;
	private JButton JBGem;
	private JCheckBox JCHarBil;
	
	private DialogSkiftKodeord DSkiftKodeord;
	
	public Panel3Data(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();	
		
		
		int JTWidth = frameSizePanel3.width/2;
		int spaceTop = 10;
		int spaceMiddle = 40;
		int JPWidth = frameSizePanel3.width/6;
		int spaceRight = (frameSizePanel3.width  - JTWidth - spaceMiddle - JPWidth)/2;
		int spaceLeft = spaceRight;
		
		//Panel 1 - Insets = Top, Venstre, Bund, Højre
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;	
		c.fill = GridBagConstraints.HORIZONTAL;
		addC(JLPersonlig,	0,	i,	3,	1,		new Insets(spaceTop,	spaceLeft,	2,		spaceMiddle));i++;
		addC(JLBrugernavn,	0,	i,	1,	1,		new Insets(30,			spaceLeft,	2,		2));
		addC(JLKodeord,		4,	i,	1,	1,		new Insets(30,			2,			2,		spaceRight));i++;
		addC(JTBrugernavn,	0,	i,	3,	1,		new Insets(2,			spaceLeft,	2,		2));
		addC(Kodeord,		4,	i,	2,	1,		new Insets(2,			2,			2,		2));
		addC(JLSkiftKodeord,6,	i,	1,	1,		new Insets(2,			2,			2,		spaceRight));i++;			
		addC(JLNavn,		0,	i,	1,	1, 		new Insets(40,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTNavn,		0,	i,	7,	1, 		new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLAdresse,		0,	i,	1,	1, 		new Insets(20,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTAdresse,		0,	i,	7,	1, 		new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLPostnummer,	0,	i,	1,	1,		new Insets(4,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTPostnummer,	0,	i,	2,	1,	 	new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JLBy,			0,	i,	1,	1, 		new Insets(4,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JTBy,			0,	i,	7,	1, 		new Insets(2,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JCHarBil,		0,	i,	1,	1, 		new Insets(20,			spaceLeft,	2,		spaceMiddle));i++;
		addC(JBGem,			0,	i,	1,	1, 		new Insets(2,			spaceLeft,	0,		spaceMiddle));i++;
		
		JLSkiftKodeord.addMouseListener(this);
		
		//Panel 2
		/*gbc.ipady = frameSizePanel3.height/2;
		gbc.anchor = GridBagConstraints.NORTH;	
		addC(JLBillede,		8,	1,	3,	12, 	new Insets(30,			2,			2,	spaceRight));	
		addC(JLSkiftBillede,9,	12,	1,	1, 		new Insets(2,	2,			2,		spaceRight));
		*/
		
		this.add(panelLeft);
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

	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, Insets space) {
		c.insets = space;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		panelLeft.add(comp, c);
		panelLeft.validate();
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
	
	private void setJComponents(){
		JLBrugernavn = new JLabel("Brugernavn");
		JTBrugernavn = new JTextField("Lise");
		JLKodeord = new JLabel("Kodeord");
		Kodeord = new JPasswordField("projekt");
		JLSkiftKodeord = new JLabel("<HTML><U>Skift Kodeord</U></HTML>");
		JTNavn = new JTextField();
		JTAdresse = new JTextField();
		JTPostnummer = new JTextField();
		JTBy = new JTextField();
		JLPersonlig = new JLabel("<HTML><U>Personlig Profil</U></HTML>");
		JLPersonlig.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLNavn = new JLabel("Navn");
		JLAdresse = new JLabel("Adresse");
		JLPostnummer = new JLabel("Postnummer");
		JLBy = new JLabel("By");
		JLSkiftBillede = new JLabel("Skift billede");
		JCHarBil = new JCheckBox("Har bil");
		JBGem = new JButton("Gem");	
		JLBillede = new JLabel("Billede", SwingConstants.CENTER);
		JLBillede.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setJLabel(JLBrugernavn);
		setJLabel(JLKodeord);
		setJLabel(JLSkiftKodeord);
		setJTextField(JTBrugernavn);
		setJTextField(Kodeord);
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JLSkiftKodeord){
			DSkiftKodeord = new DialogSkiftKodeord(parent);
			DSkiftKodeord.setAlwaysOnTop(true);
			DSkiftKodeord.setVisible(true);
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
