package client_gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements GeneralProperties {
	public static Dimension contentPaneSize;
	private DialogLogin DLogin;
	private DialogNyBruger DNyBruger;
	private GridBagConstraints c = new GridBagConstraints();
	private TaskBar tb;
	private Panel1 p1;
	private Panel2 p2;
	private PanelTemplate vist_panel;

	public MainFrame() {

		DLogin = new DialogLogin(this);
	    DLogin.setVisible(true);
	    if (DLogin.isSucceeded()){
	    	DLogin.setVisible(false);
	    }
	    
	    setDefaultProperties();
		tb = new TaskBar(this);
		p1 = new Panel1(this);
		p2 = new Panel2(this);
		vist_panel = new Panel3Data(this);
		addC(tb, 0, 0, 1, 1);
		addC(p1, 0, 1, 1, 1);
		addC(p2, 0, 2, 1, 1);
		addC(vist_panel, 0, 3, 1, 1);
		this.validate();;

		
	}

	public void removePanel() {
		this.vist_panel.setVisible(false);
		this.validate();
		this.pack();
	}

	public void addPanel(PanelTemplate panel) {
		removePanel();
		vist_panel = panel;
		addC(panel, 0, 3, 1, 1);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}

	private void addC(JComponent comp, int x, int y, int height, int width) {
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
		this.add(comp, c);
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
