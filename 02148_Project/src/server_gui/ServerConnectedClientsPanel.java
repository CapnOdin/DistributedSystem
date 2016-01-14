package server_gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ServerConnectedClientsPanel extends ServerPanelTemplate {

	private static final long serialVersionUID = 1L;
	public static DefaultListModel<String> model;
	private JScrollPane pane;
	public static JList<String> allConnections;
	private JPanel info;

	public ServerConnectedClientsPanel(ServerMainFrame parent, String ID) {
		super(parent, ID);
	}

	@Override
	public void setDefaultProperties() {
		this.setLayout(new GridLayout(1, 2));
		this.setVisible(true);
	}
	
	public static void addElementToList(String x) {
		model.addElement(x);
	}
	
	public static void removeElementFromList(String x) {
		model.removeElement(x);
	}

	@Override
	public void addContent() {
		model = new DefaultListModel<String>();
		allConnections = new JList<String>(model);
		allConnections.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allConnections.addMouseListener(this);
		
		pane = new JScrollPane(allConnections);
		info = new JPanel();
		info.setBackground(Color.white);

		this.add(pane);
		this.add(info);
		this.validate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(((JList)e.getSource()).getSelectedValue());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
