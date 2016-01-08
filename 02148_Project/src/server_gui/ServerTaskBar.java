package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class ServerTaskBar extends JMenuBar implements ServerProperties, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel power_button = new JLabel(new ImageIcon("pw.png"));
	private JLabel options_button = new JLabel(new ImageIcon("opt.png"));
	private JPanel button_holder = new JPanel(new GridLayout(1,2));
	
	private ServerMainFrame parent;
	
	private int mouse_pos_x, mouse_pos_y;
	
	public ServerTaskBar(ServerMainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		addButtons();
	}
	
	private void addButtons() {
		power_button.addMouseListener(this);
		options_button.addMouseListener(this);
		
		button_holder.add(options_button);
		button_holder.add(power_button);
		this.add(button_holder, BorderLayout.EAST);
		this.validate();
	}

	private void setDefaultProperties() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(serverTaskBarSize);
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
		this.setBackground(Color.white);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		parent.setLocation(e.getXOnScreen() - mouse_pos_x, e.getYOnScreen() - mouse_pos_y);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouse_pos_x = e.getX(); mouse_pos_y = e.getY();
		if(e.getSource() == power_button) {
			System.exit(0);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
