package matt_client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class ClientPanelTemplate extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private ClientMainFrame parent;
	private String ID;
	
	private Dimension panelTemplateSize;
	
	public ClientPanelTemplate(ClientMainFrame parent, String ID) {
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

	public String getID() {
		return ID;
	}
}
