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

public class Panel2 extends JPanel implements GeneralProperties, MouseListener{
	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	private JLabel Data = new JLabel("Data", JLabel.CENTER);
	private JLabel Forbind = new JLabel("Forbind", JLabel.CENTER);
	private JLabel Kalender = new JLabel("Kalender", JLabel.CENTER);
	private JLabel Oversigt = new JLabel("Oversigt", JLabel.CENTER);
	
	private Panel3Data p3Data;
	private Panel3Forbind p3Connect;
	public static Panel3Kalender p3Kalender;
	private Panel3Oversigt p3Oversigt;
	GridBagConstraints c = new GridBagConstraints();
	
	
	public Panel2(MainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		p3Data = new Panel3Data(parent);
		p3Connect = new Panel3Forbind(parent);
		p3Kalender = new Panel3Kalender(parent);
		p3Oversigt = new Panel3Oversigt(parent);
		
		addLabels();
	}

	private void setDefaultProperties(){
		
		this.setBackground(Color.gray);
		this.setPreferredSize(frameSizePanel2);
		this.setLayout(new GridLayout(0,4));
		this.setVisible(true);
		this.validate();
	}
	
	private void addLabels(){
		Data.addMouseListener(this);
		Forbind.addMouseListener(this);
		Kalender.addMouseListener(this);
		Oversigt.addMouseListener(this);
		Data.setFont(new Font("SansSerif", Font.BOLD, 20));
		setJLabel(Forbind);
		setJLabel(Kalender);
		setJLabel(Oversigt);		
		this.add(Data);
		this.add(Forbind);
		this.add(Kalender);
		this.add(Oversigt);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 18));
		name.setVisible(true);		
	}
	
	private void setChosenLabel(JLabel label){
		setJLabel(Data);
		setJLabel(Forbind);
		setJLabel(Kalender);
		setJLabel(Oversigt);
		label.setFont(new Font("SanSerif",Font.BOLD,20));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == Data) {
			setChosenLabel(Data);
			parent.addPanel(p3Data);
		}
		if(e.getSource() == Forbind) {
			setChosenLabel(Forbind);
			parent.addPanel(p3Connect);
		}
		if(e.getSource() == Kalender) {
			setChosenLabel(Kalender);
			parent.addPanel(p3Kalender);
		}
		if(e.getSource() == Oversigt) {
			setChosenLabel(Oversigt);
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
	/*
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
	*/
}
