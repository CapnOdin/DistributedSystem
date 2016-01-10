package client_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements GeneralProperties{
	public static Dimension contentPaneSize;
	public boolean dataPanel = false, connectPanel = false, kalenderPanel = false , oversigtPanel = false;
	
	private GridBagConstraints c = new GridBagConstraints();	
	private Panel1 p;
	private Panel2 p2;
	private Panel3 p3;
	private JPanel current_panel = new JPanel();
	
	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultProperties();
		addPanel1();
		addPanel2();
		addPanel3();
		this.validate();
	}
	
	public void addPanel1(){
		p = new Panel1(this);
		setGridBagConstraints(0, 0,1,1);
		//frameSize.height/20, frameSize.width);
		this.add(p,c);
	}
	
	public void addPanel2(){
		p2 = new Panel2(this);
		setGridBagConstraints(0, 1, 1,1);
		//(frameSize.height/20)*2, frameSize.width);
		this.add(p2, c);	
	}
	
	public void addPanel3(){
		p3 = new Panel3(this);
		setGridBagConstraints(0,2,1,1);
		//(frameSize.height/20)*17, frameSize.width);	
		this.add(p3,c);
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
		//c.fill = GridBagConstraints.BOTH;
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
		//c.weighty = height;
		//c.weightx = width;	
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
