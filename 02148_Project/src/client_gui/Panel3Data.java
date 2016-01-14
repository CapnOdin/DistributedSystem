package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.SwingConstants;

import com.sun.medialib.mlib.Image;

public class Panel3Data extends PanelTemplate implements GeneralProperties, MouseListener{
	private GridBagConstraints c = new GridBagConstraints();
	private MainFrame parent;
	private JPanel panel = new JPanel(new GridBagLayout());
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
		int spaceTop = 10;
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
		addC(Kodeord,		4,	i,	2,	1,		new Insets(space,		space,	2,		space));
		addC(JLSkiftKodeord,6,	i,	1,	1,		new Insets(space,		space,	2,		spaceMiddle));i++;			
		addC(JLNavn,		0,	i,	1,	1, 		new Insets(40,			space,	2,		spaceMiddle));i++;
		addC(JTNavn,		0,	i,	7,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JLAdresse,		0,	i,	1,	1, 		new Insets(4,			space,	2,		spaceMiddle));i++;
		addC(JTAdresse,		0,	i,	7,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JLPostnummer,	0,	i,	1,	1,		new Insets(4,			space,	2,		space));
		addC(JLBy,			2,	i,	1,	1, 		new Insets(4,			space,	2,		spaceMiddle));i++;
		addC(JTPostnummer,	0,	i,	2,	1,	 	new Insets(space,		space,	2,		space));		
		addC(JTBy,			2,	i,	5,	1, 		new Insets(space,		space,	2,		spaceMiddle));i++;
		addC(JCHarBil,		0,	i,	1,	1, 		new Insets(20,			space,	2,		spaceMiddle));i++;
		addC(JBGem,			0,	i,	1,	1, 		new Insets(space,		space,	100,	spaceMiddle));i++;
		addC(JLBillede,		7,	2,	1,	8,		new Insets(space,		space,	space,	space));
		addC(JLSkiftBillede,7,	10,	1,	1,		new Insets(space,		space,	space,	space));
		
		JLSkiftKodeord.addMouseListener(this);
		JLSkiftBillede.addMouseListener(this);
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
		JTBrugernavn = new JTextField(20);
		JLKodeord = new JLabel("Kodeord");
		Kodeord = new JPasswordField(20);
		JLSkiftKodeord = new JLabel("<HTML><U>Skift Kodeord</U></HTML>");
		JTNavn = new JTextField(30);
		JTAdresse = new JTextField(30);
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
		JLBillede = new JLabel(IProfilBillede);
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
		if (e.getSource() == JLSkiftBillede){
			
		}
		if (e. getSource() == JBGem){
			String navn = JTNavn.getText();
			System.out.println(navn);
			System.out.println(JTNavn.getText());
			System.out.println(JTAdresse.getText());
			System.out.println(JTPostnummer.getText());
			System.out.println(JTBy.getText());
			
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
