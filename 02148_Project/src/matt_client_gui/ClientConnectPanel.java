package matt_client_gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ClientConnectPanel extends ClientPanelTemplate {

	private static final long serialVersionUID = 1L;
	
	private JLabel TOBEDELETED = new JLabel("CONNECT MENU", JLabel.CENTER);

	public ClientConnectPanel(ClientMainFrame parent, String ID) {
		super(parent, ID);
		TOBEDELETED.setVisible(true);
		this.add(TOBEDELETED, BorderLayout.CENTER);
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
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
