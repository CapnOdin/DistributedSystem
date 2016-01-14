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
	
	public static Color panelColor = new Color(78,77,73);
	public static Color barColor = new Color(233,234,237);
	public static Color twitchPanel = new Color(25,25,31);
	
	public ServerPanelTemplate(ServerMainFrame parent, String ID) {
		this.parent = parent; this.ID = ID;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(barColor);
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
