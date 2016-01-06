package client_gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class DataPanel2 extends PanelTemplate{

	private static final long serialVersionUID = 1L;
	private JLabel Data, Connect, Kalender, Oversigt;
	
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
		Kalender = new JLabel("Vagter", JLabel.CENTER);
		Oversigt = new JLabel("Oversigt", JLabel.CENTER);
		Data.addMouseListener(mData);
		Connect.addMouseListener(mConnect);
		Kalender.addMouseListener(mKalender);
		Oversigt.addMouseListener(mOversigt);
		setJLabel(Data);
		setJLabel(Connect);
		setJLabel(Kalender);
		setJLabel(Oversigt);		
		this.add(Data);
		this.add(Connect);
		this.add(Kalender);
		this.add(Oversigt);
		this.validate();
		
	}
	
	
	private void setJLabel(JLabel name){
		name.setVisible(true);		
	}


	
	MouseListener mData = new MouseListener(){
	

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	};
	
	MouseListener mConnect = new MouseListener(){
		public void mouseClicked(MouseEvent e){
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	};
	
	MouseListener mKalender = new MouseListener(){
		public void mouseClicked(MouseEvent e){
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	};
	
	MouseListener mOversigt = new MouseListener(){
		public void mouseClicked(MouseEvent e){
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	};

}
