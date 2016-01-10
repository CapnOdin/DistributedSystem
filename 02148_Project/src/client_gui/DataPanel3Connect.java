package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataPanel3Connect extends PanelTemplate implements GeneralProperties{
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail, JTKodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	
	public DataPanel3Connect(){
		GridBagConstraints gbc = new GridBagConstraints();
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
		
		gbc.insets = new Insets(2,2,2,2);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(JLForbind,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(JLEMail,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(JTEMail,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(JLKodeord,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(JTKodeord,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(JCGemOplysninger,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(JBForbind,gbc);
		this.setVisible(true);
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizeDataPanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
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

	
}
