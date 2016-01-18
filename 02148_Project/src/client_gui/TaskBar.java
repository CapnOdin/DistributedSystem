package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TaskBar extends JMenuBar implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private static Dimension TaskBarSize;
	private MainFrame parent;
	
	private JLabel frametitle;
	private JLabel power_button = new JLabel(new ImageIcon("power.png"));
	private JLabel minimize_button = new JLabel(new ImageIcon("minimize.png"));
	private JPanel button_holder = new JPanel(new GridLayout());
	private static JPanel panel = new JPanel(new GridLayout());
	private int mouse_pos_x, mouse_pos_y;

	private static JLabel JLForbundet = new JLabel(" Forbundet ");
	
	
	public TaskBar(MainFrame parent) {
		this.parent = parent;
		TaskBarSize = new Dimension((int)parent.getContentPane().getWidth(), 25);
		setDefaultProperties();
		addElements();
	}

	private void addElements() {
		button_holder.add(power_button);
		button_holder.add(minimize_button);		
		button_holder.addMouseListener(this);
		button_holder.addMouseMotionListener(this);
		power_button.addMouseListener(this);
		minimize_button.addMouseListener(this);
		this.add(button_holder, BorderLayout.WEST);
		
		JLForbundet.setForeground(Color.gray);
		panel.setBackground(Color.white);
		panel.add(JLForbundet);
		JLForbundet.setVisible(false);
		this.add(panel, BorderLayout.EAST);
		
	}
	
	public static void addForbundet(){	
		JLForbundet.setVisible(true);
	}

	private void setDefaultProperties() {
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(TaskBarSize);
		this.setLayout(new BorderLayout());
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
			if (MainFrame.client.isConnected){
				MainFrame.client.disconnect();
			}
			System.exit(0);
		}
		if(e.getSource() == minimize_button){
			parent.setState(parent.ICONIFIED);
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
