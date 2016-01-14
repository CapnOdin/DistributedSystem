package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Panel3Data extends PanelTemplate implements GeneralProperties, MouseListener, ActionListener{
	private GridBagConstraints c = new GridBagConstraints();
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridBagLayout());
	private JTextField JTBrugernavn, JTEMail, JTNavn, JTAdresse, JTPostnummer, JTBy;
	private JLabel JLBrugernavn, JLKodeord,JLSkiftKodeord, JLEMail, JLPersonlig, JLNavn, JLAdresse, JLBillede, JLPostnummer, JLBy, JLSkiftBillede;
	private JPasswordField Kodeord;
	private JButton JBGem;
	private JCheckBox JCHarBil;
	private String clientData = "Lise.projekt.Lise Andersen.Grønnehøj 39.2720.Vanløse.Lise_Noerby@hotmail.com.1", brugernavn, kodeord, navn, adresse, postnummer, by, email, harBil;

	private DialogSkiftKodeord DSkiftKodeord;
	
	public Panel3Data(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setInfo();
		setJComponents();	
		int spaceTop = 60;
		int spaceMiddle = 50;
		int space = 2;
				
		//PanelLeft - Insets = Top, Venstre, Bund, Højre
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;	
		c.fill = GridBagConstraints.HORIZONTAL;
		addC(JLPersonlig,	0,	i,	3,	1,		new Insets(spaceTop,	space,	2,		spaceMiddle));i++;
		addC(JLBrugernavn,	0,	i,	1,	1,		new Insets(30,			space,	2,		space));
		addC(JLKodeord,		4,	i,	1,	1,		new Insets(30,			space,	2,		space));i++;		
		addC(JTBrugernavn,	0,	i,	3,	1,		new Insets(space,		space,	2,		space));			
		addC(Kodeord,		4,	i,	3,	1,		new Insets(space,		space,	2,		space));			
		addC(JLSkiftKodeord,7,	i,	1,	1,		new Insets(space,		space,	2,		spaceMiddle));i++;	
		addC(JLNavn,		0,	i,	1,	1, 		new Insets(40,			space,	2,		spaceMiddle));i++; 	c.ipadx = 430;
		addC(JTNavn,		0,	i,	8,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++; 	c.ipadx = 0;
		addC(JLAdresse,		0,	i,	1,	1, 		new Insets(4,			space,	2,		spaceMiddle));i++;
		addC(JTAdresse,		0,	i,	8,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JLPostnummer,	0,	i,	1,	1,		new Insets(4,			space,	2,		space));
		addC(JLBy,			2,	i,	1,	1, 		new Insets(4,			space,	2,		spaceMiddle));i++;
		addC(JTPostnummer,	0,	i,	2,	1,	 	new Insets(space,		space,	2,		space));		
		addC(JTBy,			2,	i,	6,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JLEMail,		0,	i,	1,	1,		new Insets(20	,		space,	2,		spaceMiddle));i++;
		addC(JTEMail,		0,	i,	8,	1,		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JCHarBil,		0,	i,	1,	1, 		new Insets(10,			space,	2,		spaceMiddle));i++;
		addC(JBGem,			0,	i,	8,	1, 		new Insets(space,		space,	100,	spaceMiddle));i++;
		//addC(JLBillede,		8,	2,	1,	8,		new Insets(space,		space,	space,	space));
		//addC(JLSkiftBillede,8,	10,	1,	1,		new Insets(space,		space,	space,	space));
		
		JTBy.addActionListener(this);
		JLSkiftKodeord.addMouseListener(this);
		JLSkiftBillede.addMouseListener(this);
		JBGem.addMouseListener(this);
		panel.setBackground(Color.white);
		this.add(panel);		
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
		panel.add(comp, c);
		panel.validate();
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
		ImageIcon IProfilBillede = new ImageIcon("download.jpeg");
		JLBrugernavn = new JLabel("Brugernavn");
		JTBrugernavn = new JTextField(brugernavn);
		JTBrugernavn.setEditable(false);
		JLKodeord = new JLabel("Kodeord");
		Kodeord = new JPasswordField(kodeord);
		Kodeord.setEditable(false);
		JLSkiftKodeord = new JLabel("<HTML><U>Skift Kodeord</U></HTML>");
		JTNavn = new JTextField(navn);
		JTAdresse = new JTextField(adresse);
		JTPostnummer = new JTextField(postnummer);
		JTBy = new JTextField(by);
		JTEMail = new JTextField(email);
		JLPersonlig = new JLabel("<HTML><U>Personlig Profil</U></HTML>");
		JLPersonlig.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLNavn = new JLabel("Navn");
		JLAdresse = new JLabel("Adresse");
		JLPostnummer = new JLabel("Postnummer");
		JLBy = new JLabel("By");
		JLEMail = new JLabel("E-Mail");
		JLSkiftBillede = new JLabel("Skift billede");
		JCHarBil = new JCheckBox("Har bil");
		if (harBil.equals("1")){
			JCHarBil.setSelected(true);
		}		
		JBGem = new JButton("Gem");	
		JLBillede = new JLabel(IProfilBillede);
		JLBillede.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setJLabel(JLBrugernavn);
		setJLabel(JLKodeord);
		setJLabel(JLSkiftKodeord);
		setJLabel(JLEMail);
		setJTextField(JTBrugernavn);
		setJTextField(Kodeord);
		setJTextField(JTNavn);
		setJTextField(JTAdresse);
		setJTextField(JTPostnummer);
		setJTextField(JTBy);
		setJTextField(JTEMail);
		setJLabel(JLNavn);
		setJLabel(JLAdresse);
		setJLabel(JLPostnummer);
		setJLabel(JLBy);
		setJLabel(JLSkiftBillede);
		setJCheckBox(JCHarBil);
		setJButton(JBGem);
		setJLabel(JLBillede);
	}
	
	private void setInfo(){
		//System.out.println(info);
		String[] array = clientData.split("\\.");
		//System.out.println(java.util.Arrays.toString(array));
		int i = 0;
		brugernavn = array[i];i++;
		kodeord = array[i];i++;
		navn = array[i];i++;
		adresse = array[i];i++;
		postnummer = array[i];i++;
		by = array[i];i++;
		email = array[i];i++;
		harBil = array[i];
	}
	
	private String getInfo(){
		brugernavn = JTBrugernavn.getText();
		kodeord = Kodeord.getText();
		navn = JTNavn.getText();
		adresse = JTAdresse.getText();
		postnummer = JTPostnummer.getText();
		by = JTBy.getText();
		email = JTEMail.getText();
		if (JCHarBil.isSelected()){
			harBil = "1";}
		else{
			harBil = "0";}
		clientData = brugernavn + "." + kodeord + "."+ navn+"."+adresse+"."+postnummer+"."+by + "." + email +"."+ harBil;
		return clientData;
		
	}
	
	public String getEMail(){
		return email;
	}
	
	public void opdaterKodeord(String nyeKodeord){
		kodeord = nyeKodeord;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JLSkiftKodeord){
			DSkiftKodeord = new DialogSkiftKodeord(parent);
			DSkiftKodeord.setAlwaysOnTop(true);
			DSkiftKodeord.setVisible(true);
		}
		if (e.getSource() == JLSkiftBillede){
		}
		if (e.getSource() == JBGem){
			System.out.println(getInfo());
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
		if (e.getSource() == JTBy){
			System.out.println(getInfo());
		}
		
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
