package matt_client_gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

public class ClientPlaceHolderPanel extends ClientPanelTemplate {

	private static final long serialVersionUID = 1L;
	private ServerSetupConnection login;
	
	public ClientPlaceHolderPanel(ClientMainFrame parent, String ID) {
		super(parent, ID);
		setPlaceHolderProperties();
		addLoginPrompt();
	}

	private void addLoginPrompt() {
		login = new ServerSetupConnection(super.getParent());
	}

	private void setPlaceHolderProperties() {
		this.setLayout(new BorderLayout());
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
