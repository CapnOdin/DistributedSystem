package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class ServerTaskBar extends JMenuBar implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private ServerMainFrame parent;
	
	private JLabel frametitle;
	private JLabel power_button = new JLabel(new ImageIcon("pw.png"));
	private JPanel button_holder = new JPanel(new GridLayout(1,2));
	
	private int mouse_pos_x, mouse_pos_y;
	
	public ServerTaskBar(ServerMainFrame parent, String title) {
		this.parent = parent;
		frametitle = new JLabel(title, JLabel.CENTER);
		frametitle.setBackground(Color.white);
		setDefaultProperties();
		addElements();
	}

	private void addElements() {
		button_holder.add(power_button);
		button_holder.setBackground(Color.white);
		button_holder.addMouseListener(this);
		button_holder.addMouseMotionListener(this);
		power_button.addMouseListener(this);
		this.add(button_holder, BorderLayout.EAST);
		this.add(frametitle, BorderLayout.CENTER);
	}

	private void setDefaultProperties() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouse_pos_x = e.getX();
		mouse_pos_y = e.getY();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		parent.setLocation(e.getXOnScreen() - mouse_pos_x, e.getYOnScreen() - mouse_pos_y);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == power_button) {
			System.exit(0);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
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
