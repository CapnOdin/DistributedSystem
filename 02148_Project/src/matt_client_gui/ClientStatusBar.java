package matt_client_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ClientStatusBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ClientMainFrame parent;
	private Dimension clientStatusBarSize;
	
	private JLabel activePanel = new JLabel(" Active Panel: none", JLabel.CENTER);
	private JLabel time = new JLabel("", JLabel.CENTER);
	
	public ClientStatusBar(ClientMainFrame parent) {
		this.parent = parent;
		clientStatusBarSize = new Dimension((int)parent.getContentPane().getWidth(), (int)parent.getContentPane().getHeight()/20);
		setDefaultProperties();
		addElements();
		lookForActivePanel();
	}

	private void addElements() {
		this.add(activePanel, BorderLayout.WEST);
		this.add(time, BorderLayout.EAST);
		this.validate();
	}

	private void lookForActivePanel() {
		Timer t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				activePanel.setText(" Active Panel: " + parent.getCurrent_panel().getID());
				time.setText(new Date().toString()+ " ");
			}
		});
		t.start();	
		
	}

	private void setDefaultProperties() {
		this.setVisible(true);
		this.setBackground(Color.white);
		this.setPreferredSize(clientStatusBarSize);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

}
