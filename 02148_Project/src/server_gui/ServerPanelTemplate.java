package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class ServerPanelTemplate extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private ServerMainFrame parent;
	private String ID;
	
	private Dimension panelTemplateSize;
	
	public ServerPanelTemplate(ServerMainFrame parent, String ID) {
		this.parent = parent; this.ID = ID;
		panelTemplateSize = new Dimension((int)parent.getContentPane().getWidth(),(int)(parent.getContentPane().getHeight()*0.8));
		this.setPreferredSize(panelTemplateSize);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		setDefaultProperties();
		addContent();
	}
	
	public abstract void setDefaultProperties();
	public abstract void addContent();
	
	public ServerMainFrame getParent() {
		return parent;
	}
	
	public String getID() {
		return ID;
	}
}
