package server_gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenusPanel extends JPanel implements ServerProperties, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel menu1 = new JLabel("Menu 1", JLabel.CENTER);
	private JLabel menu2 = new JLabel("Menu 2", JLabel.CENTER);
	
	private ServerPanel1 sp1 = new ServerPanel1();
	private ServerPanel2 sp2 = new ServerPanel2();
	
	private ServerMainFrame parent;
	
	public MenusPanel(ServerMainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		addLabels();
	}
	
	private void addLabels() {
		menu1.setBorder(BorderFactory.createLineBorder(Color.black));
		menu2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		menu1.addMouseListener(this);
		menu2.addMouseListener(this);
		this.add(menu1);
		this.add(menu2);
	}

	private void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(serverTaskBarSize);
		this.setLayout(new GridLayout(1,2));
		this.setVisible(true);
		this.validate();
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
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == menu1) {
			System.out.println("Menu 1 pressed!");
			parent.removeCenterPanel();
			parent.addCenterPanel(sp1);
		}
		if(e.getSource() == menu2) {
			System.out.println("Menu 2 pressed");
			parent.removeCenterPanel();
			parent.addCenterPanel(sp2);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
