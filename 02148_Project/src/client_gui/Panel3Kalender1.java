package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Panel3Kalender1 extends PanelTemplate implements GeneralProperties, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel JPVagter = new JPanel(new GridLayout(0,6));
	private JPanel ikoner = new JPanel(new GridBagLayout());
	private JPanel panel = new JPanel(new GridBagLayout());
	private JScrollPane scrollPane;
	private JButton JBTilfoj;
	private JLabel JLDato, JLTid, JLNavn, JLAdresse, JLPostnummer;
	private JLabel JLSlet = new JLabel(new ImageIcon("delete.png"));
	private JLabel JLRediger = new JLabel(new ImageIcon("edit.png"));
	private JLabel JLTimer = new JLabel(new ImageIcon("clock.png"));
	private String dato, tid, navn, adresse, postnummer;
	private String[] array;
	private String newJob;
	private int y = 0;
	
	private DialogTilfojVagt DTilfojVagt;
	
	public Panel3Kalender1(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		scrollPane =  new JScrollPane(panel,   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getNewJob("01-01-2016.08:00.Novo Nordisk. Hallas alle 1. 8000"); //Senere: hent direkte fra dialog
		//getNewJob("01-10-2016.10:00.Nordea. Helgeshøjalle 67. 8000");
		System.out.println(frameSizePanel3);
		System.out.println(KalenderDimension);
		
		c.anchor = GridBagConstraints.SOUTHEAST;
		c.ipady = 0;
		addC(JBTilfoj,0,1,1,0);
		JBTilfoj.addMouseListener(this);
		
		this.add(panel);                                       
	}
	
	private void setJComponents(){
		JPVagter.setPreferredSize(VagtDimension);
		JPVagter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPVagter.setBackground(Color.white);
		ikoner.setPreferredSize(IkonDimension);
		ikoner.setBackground(Color.white);
		JBTilfoj = new JButton("Tilføj");
		panel.setPreferredSize(KalenderDimension);
		panel.setBackground(Color.white);	
	}
	
	
	private void addC(JComponent comp, int x, int y, int width, int height){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.ipady = height;
		panel.add(comp, c);
	}
	
	private void getNewJob(String newJob){
		array = newJob.split("\\.");
		int i = 0;
		dato = array[i];i++;
		tid = array[i];i++;
		navn = array[i];i++;
		adresse = array[i];i++;
		postnummer = array[i];	
		addJob(dato,tid,navn,adresse,postnummer);
	}
		
	private void addJob(String d, String t, String n, String a, String p){
		JPVagter.add(JLDato = new JLabel(d));
		JPVagter.add(JLTid = new JLabel(t));
		JPVagter.add(JLNavn = new JLabel(n));
		JPVagter.add(JLAdresse = new JLabel(a));
		JPVagter.add(JLPostnummer = new JLabel(p));
		ikoner.add(JLTimer,c);
		ikoner.add(JLRediger,c);
		ikoner.add(JLSlet,c);
		JLTimer.addMouseListener(this);
		JLRediger.addMouseListener(this);
		JLSlet.addMouseListener(this);
		
		/*
		 * Jaa, rimeligt meget på røven her...
		MouseEvent e;
		if(e.getSource() == JLTimer){
			
		}
		*/
		JPVagter.add(ikoner);
		addC(JPVagter,0,y,1,30);y++;
	}	
	
	@Override
	void setDefaultProperties() {
		this.setPreferredSize(frameSizePanel3);
		this.setBackground(Color.white);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBTilfoj){
			DTilfojVagt = new DialogTilfojVagt(parent);
			DTilfojVagt.setAlwaysOnTop(true);
			DTilfojVagt.setVisible(true);;
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
