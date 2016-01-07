package client_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties{
	public static Dimension contentPaneSize;
	public boolean dataPanel = false, connectPanel = false, kalenderPanel = false , oversigtPanel = false;
	
	private GridBagConstraints c = new GridBagConstraints();	
	private DataPanel dp;
	private DataPanel2 dp2;
	private DataPanel3 dp3;
	
	public MainFrame() {
		setDefaultProperties();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPaneSize = getContentPane().getSize();
		System.out.println( "hej");
		
		dp = new DataPanel();
		dp2 = new DataPanel2();
		dp3 = new DataPanel3();
		setGridBagConstraints(0, 0,frameSize.height/20, frameSize.width);
		this.add(dp, c);
		setGridBagConstraints(0, 1, (frameSize.height/20)*2, frameSize.width);
		this.add(dp2, c);
		setGridBagConstraints(0,2, (frameSize.height/20)*17, frameSize.width);		
		this.add(dp3,c);
		this.validate();
	}
	
	private void setGridBagConstraints(int x, int y, int height, int width) {
		c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.weighty = height;
		c.weightx = width;	
	}

	private void setDefaultProperties() {
		contentPaneSize = this.getContentPane().getSize();
		//this.setResizable(false);
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(GeneralProperties.frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public boolean getBool(){
		return dataPanel;
	}
	public void setBool(boolean bool){
		dataPanel  = bool;
	}

}
