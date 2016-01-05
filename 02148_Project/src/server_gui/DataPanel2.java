package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class DataPanel2 extends PanelTemplate {

	private static final long serialVersionUID = 1L;
	private JLabel Data, Connect, Vagter, Oversigt;
	
	@Override
	void setBackgroundColor() {
		this.setBackground(Color.gray);
		this.validate();
	}

	@Override
	void setup() {
		this.setLayout(new GridLayout(0,4));
		Data = new JLabel("Data", JLabel.CENTER);
		Connect = new JLabel("Connect", JLabel.CENTER);
		Vagter = new JLabel("Vagter", JLabel.CENTER);
		Oversigt = new JLabel("Oversigt", JLabel.CENTER);
		setJLabel(Data);
		setJLabel(Connect);
		setJLabel(Vagter);
		setJLabel(Oversigt);		
		this.add(Data);
		this.add(Connect);
		this.add(Vagter);
		this.add(Oversigt);
		this.validate();
		
	}
	
	
	private void setJLabel(JLabel name){
		name.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
