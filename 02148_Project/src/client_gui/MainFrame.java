package client_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;

public class MainFrame extends JFrame implements GeneralProperties{
	public static Dimension contentPaneSize;
	public boolean dataPanel = false, connectPanel = false, kalenderPanel = false , oversigtPanel = false;
	
	private GridBagConstraints c = new GridBagConstraints();	
	private TaskBar tb;
	private Panel1 p1;
	private Panel2 p2;
	private PanelTemplate current_panel;
	
	
	// JDialog til ændring af password og login
	
	public MainFrame() {	
		setDefaultProperties();
		tb = new TaskBar(this);
		p1 = new Panel1(this);
		p2 = new Panel2(this);
		current_panel = new Panel3Data(this);	
		addC(tb,0,0,1,1);
		addC(p1,0,1,1,1);
		addC(p2,0,2,1,1);
		addC(current_panel,0,3,1,1);
		this.validate();
	}

	public void removePanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}

	public void addPanel(PanelTemplate panel) {
		removePanel();
		current_panel = panel;
		addC(panel, 0,3,1,1);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}
	
	private void addC(JComponent comp, int x, int y, int height, int width) {
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
		this.add(comp,c);	
	}

	private void setDefaultProperties() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		contentPaneSize = this.getContentPane().getSize();
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(GeneralProperties.frameSize);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
