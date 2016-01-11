package matt_client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientMenuPanel extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private ClientMainFrame parent;
	
	private ClientDataPanel dataPanel; 
	private ClientConnectPanel connectPanel;
	private ClientCalendarPanel calendarPanel;
	private ClientOverviewPanel overviewPanel;
	
	private Dimension clientMenuPanelSize;
	/*
	 * menus[0] = 'Data'
	 * menus[1] = 'Connect'
	 * menus[2] = 'Kalender'
	 * menus[3] = 'Oversigt'  
	 */
	private JLabel[] menus = new JLabel[4];
	
	public ClientMenuPanel(ClientMainFrame parent) {
		this.parent = parent;
		clientMenuPanelSize = new Dimension((int)parent.getContentPane().getWidth(), (int)parent.getContentPane().getHeight()/10);
		setDefaultProperties();
		addMenuProperties();
		addMenus();
	}

	private void addMenus() {
		dataPanel = new ClientDataPanel(parent, "DATA");
		connectPanel = new ClientConnectPanel(parent, "CONNECT");
		calendarPanel = new ClientCalendarPanel(parent, "CALENDAR");
		overviewPanel = new ClientOverviewPanel(parent, "OVERVIEW");
	}

	private void addMenuProperties() {
		for(int i = 0; i < menus.length; i++) {
			menus[i] = new JLabel("", JLabel.CENTER);
			menus[i].addMouseListener(this);
			menus[i].setVisible(true);
			//menus[i].setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(menus[i]);
		}
		menus[0].setText("Data");
		menus[1].setText("Connect");
		menus[2].setText("Kalender");
		menus[3].setText("Oversigt");
		this.validate();
	}

	private void setDefaultProperties() {
		this.setBackground(Color.gray);
		this.setPreferredSize(clientMenuPanelSize);
		this.setLayout(new GridLayout(1,4));
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(((JLabel)e.getSource()).getText() + " pressed!");
		
		// IF DATA-MENU PRESSED
		if(e.getSource() == menus[0]) {
			parent.addVariablePanel(dataPanel);
		}
		
		// IF CONNECT-MENU PRESSED
		if(e.getSource() == menus[1]) {
			parent.addVariablePanel(connectPanel);
		}
		
		// IF KALENDER-MENU PRESSED
		if(e.getSource() == menus[2]) {
			parent.addVariablePanel(calendarPanel);
		}
		
		// IF OVERSIGT-MENU PRESSED
		if(e.getSource() == menus[3]) {
			parent.addVariablePanel(overviewPanel);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
