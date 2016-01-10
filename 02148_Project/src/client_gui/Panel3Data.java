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
	private JTextField JTNavn, JTAdresse;
	private JLabel JLNavn, JLAdresse, JLBillede;
	private JButton JBGem;
	private JCheckBox JCHarBil;
	
	public Panel3Data(){
		
		JPanel panel = new JPanel();
		this.add(panel);
		JTNavn = new JTextField();
		JTAdresse = new JTextField();
		JLNavn = new JLabel("Navn");
		JLAdresse = new JLabel("Adresse");
		JCHarBil = new JCheckBox("Har bil");
		JBGem = new JButton("Gem");	
		JLBillede = new JLabel("Billede", SwingConstants.CENTER);
		setJTextField(JTNavn);
		setJTextField(JTAdresse);
		setJLabel(JLNavn);
		setJLabel(JLAdresse);
		setJCheckBox(JCHarBil);
		setJButton(JBGem);
		setJLabel(JLBillede);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;	
		gbc.insets = new Insets(2,2,2,2);
		addC(JLNavn,0,0,1,1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addC(JTNavn,0,1,1,1);
		addC(JLAdresse,0,2,1,1);
		addC(JTAdresse,0,3,1,1);
		addC(JCHarBil,0,4,1,1);
		addC(JBGem,0,5,1,1);
		gbc.ipady = 200;
		gbc.ipadx = 100;
		addC(JLBillede,1,0,1,6);
		JLBillede.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

	private void addC(JComponent comp, int gridx, int gridy, int width, int height) {
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		this.add(comp, gbc);
		this.validate();
	}

	
	private void setJTextField(JTextField name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
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
		
		test.add(new Panel3Data());
		test.validate();
	}
}
