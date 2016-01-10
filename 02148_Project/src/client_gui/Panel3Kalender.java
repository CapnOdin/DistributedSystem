package client_gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

public class Panel3Kalender extends PanelTemplate implements GeneralProperties{

	
	public Panel3Kalender(){
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		this.add(panel);
	}
	
	@Override
	void setDefaultProperties() {
		this.setPreferredSize(frameSizePanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel3Kalender());
		test.validate();
	}
}
