package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import server_gui.ServerMainFrame;

public class Panel2 extends PanelTemplate implements GeneralProperties, MouseListener{
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private JLabel Data = new JLabel("Data", JLabel.CENTER);
	private JLabel Connect = new JLabel("Connect", JLabel.CENTER);
	private JLabel Kalender = new JLabel("Kalender", JLabel.CENTER);
	private JLabel Oversigt = new JLabel("Oversigt", JLabel.CENTER);
	
	private Panel3Data p3Data;
	private Panel3Connect p3Connect;
	private Panel3Kalender p3Kalender;
	private Panel3Oversigt p3Oversigt;
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	public Panel2(MainFrame parent) {
		this.parent = parent;
		p3Data = new Panel3Data(parent);
		p3Connect = new Panel3Connect(parent);
		p3Kalender = new Panel3Kalender(parent);
		p3Oversigt = new Panel3Oversigt(parent);
		
		addLabels();
	}

	void setDefaultProperties(){
		
		this.setBackground(Color.gray);
		this.setPreferredSize(frameSizePanel2);
		this.setLayout(new GridLayout(0,4));
		this.setVisible(true);
		this.validate();
	}
	
	private void addLabels(){
		Data.addMouseListener(this);
		Connect.addMouseListener(this);
		Kalender.addMouseListener(this);
		Oversigt.addMouseListener(this);
		setJLabel(Data);
		setJLabel(Connect);
		setJLabel(Kalender);
		setJLabel(Oversigt);		
		this.add(Data);
		this.add(Connect);
		this.add(Kalender);
		this.add(Oversigt);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 20));
		name.setVisible(true);		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == Data) {
			System.out.println("Data pressed!");
			parent.addPanel(p3Data);
		}
		if(e.getSource() == Connect) {
			System.out.println("Connect pressed");
			parent.addPanel(p3Connect);
		}
		if(e.getSource() == Kalender) {
			System.out.println("Kalender pressed!");
			parent.addPanel(p3Kalender);
		}
		if(e.getSource() == Oversigt) {
			System.out.println("Oversigt pressed");
			parent.addPanel(p3Oversigt);
		}
		
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel2);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel2());
		test.validate();
	}

}