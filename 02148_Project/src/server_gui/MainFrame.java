package server_gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints c = new GridBagConstraints();
	
	private DataPanel dp = new DataPanel();
	private DataPanel2 dp2 = new DataPanel2();
	private DataPanel3 dp3 = new DataPanel3();
	
	public MainFrame() {
		setDefaultProperties();
		setGridBagConstraints(0, 0,frameSize.height/10, frameSize.width);
		this.add(dp, c);
		setGridBagConstraints(0, 1, (frameSize.height/20)*3, frameSize.width);
		this.add(dp2, c);
		setGridBagConstraints(0,2, (frameSize.height/4)*3, frameSize.width);
		this.add(dp3,c);
		this.validate();
	}
	
	private void setGridBagConstraints(int x, int y, int height, int width) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.ipady = height;
		c.weightx = width;	
	}

	private void setDefaultProperties() {
		this.setLayout(new GridBagLayout());
		//this.setUndecorated(true);
		//this.setLayout(new BorderLayout());
		this.setPreferredSize(frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}
