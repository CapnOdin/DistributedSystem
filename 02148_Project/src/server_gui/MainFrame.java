package server_gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c = new GridBagConstraints();
	
	private DataPanel dp = new DataPanel();
	private DataPanel2 dp2 = new DataPanel2();
	
	public MainFrame() {
		setDefaultProperties();
		setGridBagConstraints(0, 0);
		this.add(dp, c);
		setGridBagConstraints(0, 1);
		this.add(dp2, c);
		this.validate();
	}
	
	private void setGridBagConstraints(int x, int y) {
		c.gridx = x;
		c.gridy = y;
		c.fill = GridBagConstraints.BOTH;
	}

	private void setDefaultProperties() {
		this.setLayout(new GridBagLayout());
		this.setUndecorated(true);
		//this.setLayout(new BorderLayout());
		this.setPreferredSize(frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}
