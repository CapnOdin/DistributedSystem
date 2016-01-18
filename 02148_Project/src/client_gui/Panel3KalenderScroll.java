package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Panel3KalenderScroll extends JScrollPane implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton addPanel;
	private GridBagConstraints c = new GridBagConstraints();
	private int panelCount = 1;
	
	class calendarTask extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;
		private JScrollPane parent;
		private JButton[] buts = new JButton[4];
		
		public calendarTask(JScrollPane parent) {
			this.parent = parent;
			setProps();
		}

		private void setProps() {
			this.setLayout(new GridLayout(1,4));
			this.setPreferredSize(new Dimension(parent.getViewport().getWidth(), parent.getViewport().getHeight()/10));
			this.setBackground(Color.black);
			for(int i = 0; i < buts.length; i++) {
				buts[i] = new JButton();
				buts[i].addActionListener(this);
				this.add(buts[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	public void removeCalendarTask() {
		
	}
	
	public void addCalendarTask() {
		c.gridy = panelCount++;
		c.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(new calendarTask(this), c);
		this.validate();
		contentPane.validate();
		
	}
	
	public Panel3KalenderScroll() {
		setDefaultProperties();
	}
	
	private void setDefaultProperties() {
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane = new JPanel(new GridBagLayout());
		this.setViewportView(contentPane);
		contentPane.setBackground(Color.magenta);
		addPanel = new JButton("New Panel");
		addPanel.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(addPanel, c);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800,600));
		frame.add(new Panel3KalenderScroll());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPanel) {
			for(int i = 0; i < 30; i++) {
				addCalendarTask();
			}
		}
		
	}
	
}
