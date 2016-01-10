package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataPanel3Data extends PanelTemplate implements GeneralProperties{
	private JTextField JTNavn, JTAdresse;
	private JLabel JLNavn, JLAdresse, JLBillede;
	private JButton JBGem;
	private JCheckBox JCHarBil;
	
	public DataPanel3Data(){
		GridBagConstraints c = new GridBagConstraints();
		JPanel panel = new JPanel();
		this.add(panel);
		JPanel infoPanel = new JPanel();
		JPanel picturePanel = new JPanel();
		infoPanel = createInfoPanel(infoPanel);
		picturePanel = createPicturePanel(picturePanel);
		//c.anchor = GridBagConstraints.CENTER;
		//c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		panel.add(infoPanel,c);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(picturePanel,c);
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizeDataPanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}

	
	private JPanel createInfoPanel(JPanel panel){
		panel.setBackground(Color.white);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JTNavn = new JTextField();
		JTAdresse = new JTextField();
		JLNavn = new JLabel("Navn");
		JLAdresse = new JLabel("Adresse");
		JCHarBil = new JCheckBox("Har bil");
		JBGem = new JButton("Gem");		
		setJTextField(JTNavn);
		setJTextField(JTAdresse);
		setJLabel(JLNavn);
		setJLabel(JLAdresse);
		setJCheckBox(JCHarBil);
		setJButton(JBGem);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(2,2,2,2);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(JLNavn,gbc);		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(JTNavn,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(JLAdresse,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(JTAdresse,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(JCHarBil,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(JBGem,gbc);
		this.setVisible(true);		
		return panel;
	}
	
	private JPanel createPicturePanel(JPanel panel){
		panel.setBackground(Color.white);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLBillede = new JLabel("Billede", SwingConstants.CENTER);
		setJLabel(JLBillede);
		gbc.ipady = 200;
		gbc.ipadx = 100;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(JLBillede,gbc);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
		return panel;
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
}
