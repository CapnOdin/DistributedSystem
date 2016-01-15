package client_gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Panel3Kalender extends PanelTemplate implements GeneralProperties, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel JPVagter = new JPanel(new GridLayout(0,5));
	private JPanel panel = new JPanel(new GridBagLayout());
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton JBTilfoj;
	private String dato, tid, navn, adresse, postnummer;
	private JLabel JLDato, JLTid, JLNavn, JLAdresse, JLPostnummer;
	private String[] array;
	private String newJob;
	private JPanel oversigt = new JPanel(new SpringLayout());
	private JTextField[] textfield = new JTextField[75];
	private int field = 0;
	
	private DialogTilfojVagt DTilfojVagt;
	
	public Panel3Kalender(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		getNewJob("01-01-2016.08:00.Novo Nordisk. Hallas alle 1. 8000"); //Senere: hent direkte fra dialog
		getNewJob("01-10-2016.10:00.Nordea. Helgeshøjalle 67. 8000");
		/*for (int i = 0; i<75;i++){ oversigt.add(textfield[i]); }
		SpringUtilities.makeGrid(oversigt,16, 5, 0, 0, 0, 0);
		*/
		addC(textArea,0,0,1);
		c.anchor = GridBagConstraints.SOUTHEAST;
		addC(JBTilfoj,0,1,1);
		JBTilfoj.addMouseListener(this);
		
		this.add(panel);                                       
	}
	
	private void setJComponents(){
		textArea = new JTextArea("Fyld ud med vagter \n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nEr jeg ude over nu?\n");
		scrollPane = new JScrollPane(textArea);  
		textArea.setPreferredSize(JTextAreaDimension);
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//textArea.setLineWrap(true);  
		//textArea.setWrapStyleWord(true); 
		
		
		/*JPVagter.setPreferredSize(JTextAreaDimension);
		JPVagter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPVagter.setBackground(Color.white);*/
		/*oversigt.add(new JLabel("Dato"));
		oversigt.add(new JLabel("Tid"));
		oversigt.add(new JLabel("Titel"));
		oversigt.add(new JLabel("Adresse"));
		oversigt.add(new JLabel("Postnummer"));
		for (int i = 0; i < 75; i++) {
			textfield[i] = new JTextField();
		    
		}
		oversigt.setPreferredSize(JTextAreaDimension);
		oversigt.setBackground(Color.white);*/
		JBTilfoj = new JButton("Tilføj");
		panel.setBackground(Color.white);	
	}
	
	private void addC(JComponent comp, int x, int y, int width){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
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
		addJob1(dato,tid,navn,adresse,postnummer);
	}

	
	private void addJob1(String d, String t, String n, String a, String p){
		textfield[field] = new JTextField(d);field++;
		textfield[field] = new JTextField(t);field++;
		textfield[field] = new JTextField(n);field++;
		textfield[field] = new JTextField(a);field++;
		textfield[field] = new JTextField(p);field++;
		
	}
		
	private void addJob(String d, String t, String n, String a, String p){
		JPVagter.add(JLDato = new JLabel(d));
		JPVagter.add(JLTid = new JLabel(t));
		JPVagter.add(JLNavn = new JLabel(n));
		JPVagter.add(JLAdresse = new JLabel(a));
		JPVagter.add(JLPostnummer = new JLabel(p));
		
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
