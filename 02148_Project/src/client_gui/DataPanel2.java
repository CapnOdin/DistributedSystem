package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import server_gui.ServerMainFrame;

public class DataPanel2 extends PanelTemplate implements GeneralProperties, MouseListener{
	private static final long serialVersionUID = 1L;
	
	private JLabel Data = new JLabel("Data", JLabel.CENTER);
	private JLabel Connect = new JLabel("Connect", JLabel.CENTER);
	private JLabel Kalender = new JLabel("Kalender", JLabel.CENTER);
	private JLabel Oversigt = new JLabel("Oversigt", JLabel.CENTER);
	
	private DataPanel3Data dp3Data = new DataPanel3Data();
	private DataPanel3Connect dp3Connect = new DataPanel3Connect();
	private DataPanel3Kalender dp3Kalender = new DataPanel3Kalender();
	private DataPanel3Oversigt dp3Oversigt = new DataPanel3Oversigt();
	GridBagConstraints gbc = new GridBagConstraints();
	
	private MainFrame parent;
	
	public DataPanel2(MainFrame parent) {
		this.parent = parent;
		addLabels();
	}

	void setDefaultProperties(){
		
		this.setBackground(Color.gray);
		this.setPreferredSize(frameSizeDataPanel2);
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
			parent.removePanel();
			parent.addPanel(dp3Data);
		}
		if(e.getSource() == Connect) {
			System.out.println("Connect pressed");
			parent.removePanel();
			parent.addPanel(dp3Connect);
		}
		if(e.getSource() == Kalender) {
			System.out.println("Kalender pressed!");
			parent.removePanel();
			parent.addPanel(dp3Kalender);
		}
		if(e.getSource() == Oversigt) {
			System.out.println("Oversigt pressed");
			parent.removePanel();
			parent.addPanel(dp3Oversigt);
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


}
