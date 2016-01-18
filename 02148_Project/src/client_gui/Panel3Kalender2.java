package client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class Panel3Kalender2 extends PanelTemplate implements ActionListener {

	private static final long serialVersionUID = 1L;
	private MainFrame parent;
	
	private JScrollPane scrollPane;
	private JPanel contentPane, toolBar;
	private JButton JBAddCalendarTask;
	
	private GridBagConstraints c;
	private int panelCount;
	
	private HashMap<String, CalendarTask> allCalendarElements;
	
	public Panel3Kalender2(MainFrame parent) {
		this.parent = parent;
	}
	
	@Override
	void setDefaultProperties() {
		allCalendarElements = new HashMap<String, CalendarTask>();
		setContainerProperties();
		setPanelProperties();
		addContent();
	}
	
	private void setContainerProperties() {
		this.setLayout(new BorderLayout());
	}
	
	private void setPanelProperties() {
		// Scrollpane properties
		panelCount = 0;
		contentPane = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		scrollPane = new JScrollPane(contentPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.setBackground(Color.white);
		
		// Toolbar properties
		toolBar = new JPanel(new BorderLayout());
		JBAddCalendarTask = new JButton("Tilføj");
		JBAddCalendarTask.addActionListener(this);
		toolBar.add(JBAddCalendarTask, BorderLayout.EAST);
	}
	
	public void addCalendarTask() {
		c.gridy = panelCount++;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		CalendarTask task = new CalendarTask(scrollPane, ""); // FIND EN MÅDE AT GØRE HVER TASK UNIK PÅ.
		allCalendarElements.put(task.getID(), task);
		
		contentPane.add(task, c);
		
		scrollPane.validate();
		contentPane.validate();
	}
	
	private void addContent() {
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(toolBar, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == JBAddCalendarTask) {
			addCalendarTask();
		}
	}
	
	class CalendarTask extends JPanel implements MouseListener {

		private static final long serialVersionUID = 1L;
		
		private JScrollPane parent;
		private JPanel tools;
		private JLabel[] toolButtons = new JLabel[3];
		private JTextField[] labels = new JTextField[5]; 
		
		private String ID;
		
		public CalendarTask(JScrollPane parent, String ID) {
			this.parent = parent; this.ID = ID;
			System.out.println("CREATED NEW PANEL");
			setTaskPanelProperties();
			setLabelProperties();
			setToolsProperties();
			addC();
		}
		
		private void setTaskPanelProperties() {
			this.setLayout(new GridLayout(1,6));
			this.setPreferredSize(new Dimension(parent.getViewport().getWidth(), parent.getViewport().getHeight()/10));
			this.setVisible(true);
		}
		
		private void setLabelProperties() {
			for(int i = 0; i < labels.length; i++) {
				labels[i] = new JTextField("");
				labels[i].setEditable(false);
				labels[i].setVisible(true);
				labels[i].setBackground(Color.white);
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
			for(int i = 0; i < labels.length; i++) {
				this.add(labels[i]);
			}
			this.setBorder(BorderFactory.createLineBorder(Color.black));
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

		@Override
		public void mouseClicked(MouseEvent e) {
			parent.requestFocus();
			if(e.getSource() == toolButtons[1]) {
				for(int i = 0; i < labels.length; i++) {
					labels[i].setEditable(true);
				}
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
		
	}

}
