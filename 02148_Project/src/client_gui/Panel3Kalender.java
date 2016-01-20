package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import client_eng.TCPClient;

public class Panel3Kalender extends JPanel implements GeneralProperties, MouseListener {

	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	
	private JScrollPane scrollPane;
	private JPanel contentPane, overskrift;
	private JButton JBAddCalendarTask;
	
	private GridBagConstraints c = new GridBagConstraints();
	private int panelCount;
	
	private HashMap<String, CalendarTask> allCalendarElements;
	private DialogTilfojVagt DTilfojVagt;
	private DialogTimeRegistrering DTimeRegistrering;
	
	public Panel3Kalender(MainFrame parent) {
		this.parent = parent;
		setDefaultProperties();
		setPanelProperties();
		setOverskrift();
		addContent();
	}
	
	private void setDefaultProperties() {
		this.setPreferredSize(frameSizePanel3);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		allCalendarElements = new HashMap<String, CalendarTask>();
	}
	
	private void setPanelProperties() {
		panelCount = 0;
		contentPane = new JPanel(new GridBagLayout());
		contentPane.setBackground(Color.white);
		scrollPane = new JScrollPane(contentPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.setBackground(Color.white);
		JBAddCalendarTask = new JButton("Tilføj");
		JBAddCalendarTask.addMouseListener(this);
	}
	
	private void setOverskrift(){
		overskrift = new JPanel(new GridLayout(0,6));
		overskrift.setPreferredSize(VagtDimension);
		overskrift.setBackground(Color.white);
		overskrift.add(setJLabel("Dato"));
		overskrift.add(setJLabel("Tid"));
		overskrift.add(setJLabel("Opgave Navn"));
		overskrift.add(setJLabel("Adresse"));
		overskrift.add(setJLabel("Postnummer"));
		overskrift.add(setJLabel(""));
	}
	
	private JLabel setJLabel(String name){
		JLabel label = new JLabel(name);
		label.setFont(new Font("SansSerif", Font.ITALIC, 14));
		label.setVisible(true);
		return label;
	}
	
	public void addCalendarTask(String dato, String tid, String navn, String adresse, String postnummer) {
		c.anchor = GridBagConstraints.NORTH;
		c.gridy = panelCount++;
		c.fill = GridBagConstraints.HORIZONTAL;
		CalendarTask task = new CalendarTask(scrollPane, dato, tid, navn, adresse, postnummer, ""); // FIND EN MÅDE AT GØRE HVER TASK UNIK PÅ.
		allCalendarElements.put(task.getID(), task);
		contentPane.add(task, c);		
		scrollPane.validate();
		contentPane.validate();
	}
	
	private void addContent() {
		this.add(overskrift, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(JBAddCalendarTask, BorderLayout.SOUTH);
	}
	
	public void setVagter(){
		String[] navne = MainFrame.profile.calendar.get_job_names();
		for ( int i = 0; i < navne.length;i++){
			String dato = MainFrame.profile.calendar.get_job(navne[i]).get("start");
			String tid = MainFrame.profile.calendar.get_job(navne[i]).get("start");
			String navn = MainFrame.profile.calendar.get_job(navne[i]).get("description");
			String adresse = MainFrame.profile.calendar.get_job(navne[i]).get("title");
			String postnummer = MainFrame.profile.calendar.get_job(navne[i]).get("title");
			//String[] jobs = MainFrame.profile.calendar.get_job(navne[i]);
			System.out.println(dato);
			System.out.println(tid);
			System.out.println(navn);
			addCalendarTask(dato, tid, navn, adresse, postnummer);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == JBAddCalendarTask) {
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
	
	class CalendarTask extends JPanel implements MouseListener, ActionListener {

		private static final long serialVersionUID = 1L;
		
		private JScrollPane parent;
		private JPanel tools;
		private JLabel[] toolButtons = new JLabel[3];
		private JTextField[] labels = new JTextField[5]; 
		
		private String ID;
		
		public CalendarTask(JScrollPane parent, String dato, String tid, String navn, String adresse, String postnummer,String ID) {
			this.parent = parent; this.ID = ID;
			System.out.println("CREATED NEW PANEL");
			setTaskPanelProperties();
			setLabelProperties(dato, tid, navn, adresse, postnummer);
			setToolsProperties();
			addC();
		}
		
		private void setTaskPanelProperties() {
			this.setLayout(new GridLayout(1,6));
			this.setBackground(Color.white);
			this.setPreferredSize(new Dimension(parent.getWidth(), parent.getHeight()/15));
			this.setVisible(true);
		}
		
		private void setLabelProperties(String dato, String tid, String navn, String adresse, String postnummer) {
			labels[0] = new JTextField(dato);
			labels[1] = new JTextField(tid);
			labels[2] = new JTextField(navn);
			labels[3] = new JTextField(adresse);
			labels[4] = new JTextField(postnummer);
			for(int i = 0; i < labels.length; i++) {
				labels[i].setEditable(false);
				labels[i].setVisible(true);
				labels[i].setBackground(Color.white);
				labels[i].addActionListener(this);
			}
		}
		
		private void setToolsProperties() {
			tools = new JPanel(new GridLayout(1,3));
			
			toolButtons[0] = new JLabel(new ImageIcon("clock.png"));
			toolButtons[1] = new JLabel(new ImageIcon("edit.png"));
			toolButtons[2] = new JLabel(new ImageIcon("delete.png"));
			
			for(int i = 0; i < toolButtons.length; i++) {
				toolButtons[i].addMouseListener(this);
				tools.add(toolButtons[i]);
			}
			tools.setBackground(Color.white);
			tools.setVisible(true);
		}
		
		private void addC() {
			c.anchor = GridBagConstraints.NORTH;
			for(int i = 0; i < labels.length; i++) {
				this.add(labels[i],c);
			}
			//this.setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(tools);
			this.validate();
		}
		
		public void setLabelContent(String dato, String starttid, String opgavetitel, String adresse, String postnummer) {
			labels[0].setText(dato);
			labels[1].setText(starttid);
			labels[2].setText(opgavetitel);
			labels[3].setText(adresse);
			labels[4].setText(postnummer);
		}
		
		public void setLabelsEditable(boolean bool) {
			for(int i = 0; i < labels.length; i++) {
				labels[i].setEditable(bool);
			}
		}
		
		private String updateVagt(){
			int i = 0;
			String dato = labels[i].getText();i++;
			String tid = labels[i].getText();i++;
			String navn = labels[i].getText();i++;
			String adresse = labels[i].getText();i++;
			String postnummer = labels[i].getText();
			String sessionID = TCPClient.getSessionID();
			String updateJob = "A12."+ dato + "." + tid + "." + navn + "." + adresse + "." + postnummer + "." + sessionID;
			return updateJob;
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			parent.requestFocus();
			if (e.getSource() == toolButtons[0]){
				DTimeRegistrering = new DialogTimeRegistrering(MainFrame.panel2.parent);
				DTimeRegistrering.setAlwaysOnTop(true);
				DTimeRegistrering.setVisible(true);
			}
			if(e.getSource() == toolButtons[1]) {
				for(int i = 0; i < labels.length; i++) {
					labels[i].setEditable(true);
				}
			}
			if(e.getSource() == toolButtons[2]){
				//Slet vagt
			}			
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
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public String getID() {
			return ID;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int j =0;j<5;j++){
				if (e.getSource() == labels[j]){
					for(int i = 0; i < labels.length; i++) {
						labels[i].setEditable(false);
					}
					MainFrame.client.sendMessage(updateVagt());
				}
			}
			
		}
	}
}
