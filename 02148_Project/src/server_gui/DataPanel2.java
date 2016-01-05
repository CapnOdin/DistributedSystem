package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
	void setPanelSize() {
		this.setPreferredSize(new Dimension(frameSize.width, (frameSize.height/10)*2));
	}

	@Override
	void setup() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		Data = new JLabel("Data");
		Connect = new JLabel("Connect");
		Vagter = new JLabel("Vagter");
		Oversigt = new JLabel("Oversigt");
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
		//name.setPreferredSize(labelSize);
		name.setVisible(true);
	}


}
