package tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LiseGridBagDemo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel[] panels = new JPanel[4];
	
	public LiseGridBagDemo() {
		setDefaultProperties();
		setPanelProperties();
		addPanels();
	}
	
	private void addPanels() {
		
		// BEDRE LØSNING
		addC(panels[0], 0, 0, 2, 1);
		addC(panels[1], 0, 1, 1, 1);
		addC(panels[2], 1, 1, 1, 1);
		addC(panels[3], 0, 2, 2, 1);
		
		// DÅRLIG LØSNING
		/*c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(panels[0],c);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		this.add(panels[1], c);
		c.gridx = 1;
		this.add(panels[2], c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		this.add(panels[3], c);
		this.validate();*/
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		this.add(comp, c);
		this.validate();
	}

	private void setPanelProperties() {
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setVisible(true);
		}
		panels[0].setBackground(Color.orange);
		panels[1].setBackground(Color.black);
		panels[2].setBackground(Color.cyan);
		panels[3].setBackground(Color.green);
		
		// DÅRLIG LØSNING, BRUGER SAMME DIMENSION FLERE GANGE...
		panels[0].setPreferredSize(new Dimension((int)this.getContentPane().getSize().getWidth(), (int)this.getContentPane().getSize().getHeight()/3));
		panels[1].setPreferredSize(new Dimension((int)this.getContentPane().getSize().getWidth()/2,(int)this.getContentPane().getSize().getHeight()/3));
		panels[2].setPreferredSize(new Dimension((int)this.getContentPane().getSize().getWidth()/2,(int)this.getContentPane().getSize().getHeight()/3));
		panels[3].setPreferredSize(new Dimension((int)this.getContentPane().getSize().getWidth(), (int)this.getContentPane().getSize().getHeight()/3));
	}

	private void setDefaultProperties() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new GridBagLayout());
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new LiseGridBagDemo();
	}
	
}
