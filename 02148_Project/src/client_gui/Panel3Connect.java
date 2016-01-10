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

public class Panel3Connect extends PanelTemplate implements GeneralProperties{
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail, JTKodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	
	
	public Panel3Connect(){
		
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
		addC(JLForbind,0,0,1,1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addC(JLEMail,0,1,1,1);
		addC(JTEMail,0,2,1,1);
		addC(JLKodeord,0,3,1,1);
		addC(JTKodeord,0,4,1,1);
		addC(JCGemOplysninger,0,5,1,1);
		addC(JBForbind,0,6,1,1);
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
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel3Connect());
		test.validate();
	}
}
