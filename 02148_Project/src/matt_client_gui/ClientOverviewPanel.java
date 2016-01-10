package matt_client_gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ClientOverviewPanel extends ClientPanelTemplate {

	private static final long serialVersionUID = 1L;
	
	private JLabel TOBEDELETED = new JLabel("OVERSIGT MENU", JLabel.CENTER);

	public ClientOverviewPanel(ClientMainFrame parent, String ID) {
		super(parent, ID);
		
		TOBEDELETED.setVisible(true);
		this.add(TOBEDELETED, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultProperties() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContent() {
		// TODO Auto-generated method stub
		
	}

}
