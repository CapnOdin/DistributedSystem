package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TaskBar extends JMenuBar implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private static Dimension TaskBarSize;
	private MainFrame parent;
	
	private JLabel frametitle;
	private JLabel power_button = new JLabel(new ImageIcon("pw.png"));
	private JLabel options_button = new JLabel(new ImageIcon("opt.png"));
	private JPanel button_holder = new JPanel(new GridLayout(1,2));
	private int mouse_pos_x, mouse_pos_y;
	
	
	public TaskBar(MainFrame parent) {
		this.parent = parent;
		TaskBarSize = new Dimension((int)parent.getContentPane().getWidth(), ((int)parent.getContentPane().getHeight()/20));
		setDefaultProperties();
		addElements();
	}

	private void addElements() {
		button_holder.add(power_button);
		button_holder.add(options_button);		
		button_holder.addMouseListener(this);
		button_holder.addMouseMotionListener(this);
		power_button.addMouseListener(this);
		options_button.addMouseListener(this);
		this.add(button_holder, BorderLayout.WEST);
	}

	private void setDefaultProperties() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(TaskBarSize);
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
		this.setBackground(Color.gray);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
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
	
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(TaskBarSize);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new TaskBar());
		test.validate();
	}
}
