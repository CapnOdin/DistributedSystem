package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Panel3Kalender extends PanelTemplate implements GeneralProperties, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton JBTilføj;
	
	
	private DialogTilføjVagt DTilføjVagt;
	
	public Panel3Kalender(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		addC(textArea,0,0,1);
		c.anchor = GridBagConstraints.SOUTHEAST;
		addC(JBTilføj,0,1,1);
		JBTilføj.addMouseListener(this);
		
		this.add(panel);                                       
	}
	
	private void setJComponents(){
		textArea = new JTextArea("Fyld ud med vagter \n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nEr jeg ude over nu?\n");
		scrollPane = new JScrollPane(textArea);  
		JBTilføj = new JButton("Tilføj");
		textArea.setPreferredSize(JTextAreaDimension);
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//textArea.setLineWrap(true);  
		//textArea.setWrapStyleWord(true); 
		
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		panel.add(comp, c);
	}
	
	@Override
	void setDefaultProperties() {
		this.setPreferredSize(frameSizePanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBTilføj){
			DTilføjVagt = new DialogTilføjVagt(parent);
			DTilføjVagt.setAlwaysOnTop(true);
			DTilføjVagt.setVisible(true);;
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
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		//test.add(new Panel3Kalender());
		test.validate();
	}
	*/
}
