package matt_client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ClientMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension frameSize = new Dimension((int)screenSize.getWidth()/2,(int)screenSize.getHeight()/2);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private ClientMenuPanel cmp;
	private ClientTaskBar ctb;
	private ClientStatusBar csb;
	//private ClientDataPanel test;
	
	private ClientPanelTemplate current_panel;
	
	public ClientMainFrame() {
		setDefaultProperties();
		addStaticPanels();
	}

	public void addVariablePanel(ClientPanelTemplate panel) {
		removeVariablePanel();
		current_panel = panel;
		addC(panel, 0, 2, 1, 1);
		//this.add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		this.validate();
		this.pack();
	}
	
	private void removeVariablePanel() {
		this.current_panel.setVisible(false);
		this.validate();
		this.pack();
	}
	
	private void addStaticPanels() {
		cmp = new ClientMenuPanel(this);
		ctb = new ClientTaskBar(this, "CLIENT");
		csb = new ClientStatusBar(this);
		current_panel = new ClientPlaceHolderPanel(this, "PLACEHOLDER");
		
		addC(ctb, 0, 0, 1, 1);
		addC(cmp, 0, 1, 1, 1);
		addC(current_panel, 0, 2, 1, 1);
		addC(csb, 0, 3, 1, 1);
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight) {
		c.gridx = gridx; c.gridy = gridy;
		c.gridwidth = gridwidth; c.gridheight = gridheight;
		this.add(comp, c);
		this.validate();
	}

	private void setDefaultProperties() {
		this.getContentPane().setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(frameSize);
		this.setUndecorated(true);
		this.setLayout(new GridBagLayout());
		//this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new ClientMainFrame();
	}

	public ClientPanelTemplate getCurrent_panel() {
		return current_panel;
	}

}
