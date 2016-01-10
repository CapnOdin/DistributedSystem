package client_gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements GeneralProperties{
	public static Dimension contentPaneSize;
	public boolean dataPanel = false, connectPanel = false, kalenderPanel = false , oversigtPanel = false;
	
	private GridBagConstraints c = new GridBagConstraints();	
	private DataPanel dp;
	private DataPanel2 dp2;
	private DataPanel3Data dp3Data;
	private JPanel current_panel = new JPanel();
	
	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultProperties();
		addDataPanel1();
		addDataPanel2();
		addDataPanel3();
		this.validate();
	}
	
	public void addDataPanel1(){
		dp = new DataPanel(this);
		setGridBagConstraints(0, 0,frameSize.height/20, frameSize.width);
		this.add(dp,c);
	}
	
	public void addDataPanel2(){
		dp2 = new DataPanel2(this);
		setGridBagConstraints(0, 1, (frameSize.height/20)*2, frameSize.width);
		this.add(dp2, c);	
	}
	
	public void addDataPanel3(){
		dp3Data = new DataPanel3Data();
		setGridBagConstraints(0,2, (frameSize.height/20)*17, frameSize.width);	
		this.add(dp3Data,c);
	}
	public void removePanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}

	public void addPanel(JPanel panel) {
		current_panel = panel;
		this.add(panel, c);
		panel.setVisible(true);
		this.validate();
		this.pack();
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
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(GeneralProperties.frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
