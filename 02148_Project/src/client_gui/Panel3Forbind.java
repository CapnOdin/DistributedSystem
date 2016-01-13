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
	private GridBagConstraints c = new GridBagConstraints();
	JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail, JTKodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	
	public Panel3Forbind(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		int JTWidth = frameSizePanel3.width / 2;
		int spaceLeft = frameSizePanel3.width / 4;
		int spaceRight = spaceLeft;
		int spaceTop = 40;
		int spaceSTD = 4;
		int spaceExtra = 20;
		int spaceButtom = 	frameSizePanel3.height - spaceTop - JLForbind.getHeight() - spaceExtra - JLEMail.getHeight() - spaceSTD- 
							JTEMail.getHeight() - spaceExtra - JLKodeord.getHeight() - spaceSTD - JTKodeord.getHeight() - spaceExtra - 
							JCGemOplysninger.getHeight() - spaceSTD -JBForbind.getHeight();
		
		
		// Insets = Top, Venstre, Bund, Højre
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.BOTH;
		addC(JLForbind,			0,	i,	1,	1,	0,			new Insets(spaceTop,	spaceLeft,	2,	spaceRight));i++;
		addC(JLEMail,			0,	i,	1,	1,	0,			new Insets(spaceExtra,			spaceLeft,	0,	spaceRight));i++;
		addC(JTEMail,			0,	i,	1,	1,	JTWidth,	new Insets(spaceSTD,			spaceLeft,	0,	spaceRight));i++;
		addC(JLKodeord,			0,	i,	1,	1,	0,			new Insets(spaceExtra,			spaceLeft,	0,	spaceRight));i++;
		addC(JTKodeord,			0,	i,	1,	1,	JTWidth,	new Insets(spaceSTD,			spaceLeft,	0,	spaceRight));i++;
		addC(JCGemOplysninger,	0,	i,	1,	1,	0,			new Insets(spaceExtra,			spaceLeft,	0,	spaceRight));i++;
		addC(JBForbind,			0,	i,	1,	1,	0,			new Insets(spaceSTD,			spaceLeft,	40,	spaceRight));i++;
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
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, int width, Insets space) {
		c.insets = space;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.ipadx = width;
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
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(frameSizePanel3);
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel3Connect());
		test.validate();
	}
	*/
}
