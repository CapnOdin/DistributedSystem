package server_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	private GridBagConstraints c = new GridBagConstraints();	
	private DataPanel dp;
	private DataPanel2 dp2;
	private DataPanel3 dp3;
	
	public static Dimension contentPaneSize;
	public static Dimension JLabelSize;
	
	public MainFrame() {
		setDefaultProperties();
		Dimension CPSize = new Dimension (this.getContentPane().getSize());		
		contentPaneSize = getContentPane().getSize();
		JLabelSize = new Dimension((contentPaneSize.width / 4), (contentPaneSize.height/10*2));
		dp = new DataPanel();
		dp2 = new DataPanel2();
		dp3 = new DataPanel3();
		System.out.println(contentPaneSize);
		System.out.println(JLabelSize);
		System.out.println(GeneralProperties.frameSize);
		setGridBagConstraints(0, 0,GeneralProperties.frameSize.height/10, GeneralProperties.frameSize.width);
		this.add(dp, c);
		setGridBagConstraints(0, 1, (GeneralProperties.frameSize.height/20)*3, GeneralProperties.frameSize.width);
		this.add(dp2, c);
		setGridBagConstraints(0,2, (GeneralProperties.frameSize.height/4)*3, GeneralProperties.frameSize.width);
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
		contentPaneSize = this.getContentPane().getSize();
		this.setResizable(false);
		this.setLayout(new GridBagLayout());
		//this.setUndecorated(true);
		//this.setLayout(new BorderLayout());
		this.setPreferredSize(GeneralProperties.frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public Dimension getFrameContentPaneSize() {
		return contentPaneSize;
	}

}
