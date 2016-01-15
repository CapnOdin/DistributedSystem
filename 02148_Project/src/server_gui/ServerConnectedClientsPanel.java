package server_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import server_eng.TCPServer;

public class ServerConnectedClientsPanel extends ServerPanelTemplate implements ActionListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	public static DefaultListModel<String> model;
	public static JList<String> allConnections;
	private JScrollPane pane;
	
	private JPanel info;
	private JScrollPane clientHistory;
	
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel[] infoLabels = new JLabel[6];
	private JTextField[] infoLabelFields = new JTextField[5];
	private Font bigFont;
	
	private JLabel[] chatLabels = new JLabel[2];
	private JTextField chatMessage = new JTextField();
	public static JTextArea chatArea = new JTextArea();
	private JScrollPane chatPane = new JScrollPane(chatArea);
	private JButton send = new JButton("Send");
	private JPanel button_holder = new JPanel(new GridLayout(1,4));
	private JButton[] actionButtons = new JButton[4];
	
	private String clientAlias, clientIP, selectedClient, clientSessionID;
	//private int clientUserNo;
	public ServerConnectedClientsPanel(ServerMainFrame parent, String ID) {
		super(parent, ID);
		addInfoPanelContent();
		addChatPanelContent();
		addPanels();
	}

	private void addChatPanelContent() {
		chatArea.setEditable(false);
		
		chatLabels[0] = new JLabel(" Actions", JLabel.LEFT);
		chatLabels[0].setFont(bigFont);
		chatLabels[1] = new JLabel(" Chat:", JLabel.LEFT);
		
		send.addActionListener(this);
		
		addC(info, chatLabels[0], 0, 7, 3, 0);
		addC(info, chatLabels[1], 0, 8, 1, 0);
		addC(info, chatPane, 0, 9, 3, 50);
		addC(info, chatMessage, 0, 10, 2, 0);
		addC(info, send, 2, 10, 1, 0);
		
		for(int i = 0; i < actionButtons.length; i++) {
			actionButtons[i] = new JButton(""+(i+1)); 
			actionButtons[i].addActionListener(this);
			button_holder.add(actionButtons[i]);
		}
		
		addC(info, button_holder, 0, 12, 3, 20);
		
		actionButtons[0].setText("Disconnect");
	}

	private void addInfoPanelContent() {
		model = new DefaultListModel<String>();
		chatPane.setMaximumSize(chatPane.getSize());
		allConnections = new JList<String>(model);
		allConnections.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allConnections.setBackground(ServerPanelTemplate.barColor);
		allConnections.addMouseMotionListener(this);
		allConnections.addMouseListener(this);
		allConnections.setSelectionBackground(twitchPanel);
		
		pane = new JScrollPane(allConnections);
		pane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		info = new JPanel(new GridBagLayout());
		info.setBackground(ServerPanelTemplate.barColor);
		
		for(int i = 0; i < infoLabels.length; i++) {
			infoLabels[i] = new JLabel("", JLabel.LEFT);
			infoLabels[i].setText("" + (i+1));
		}
		
		for(int i = 0; i < infoLabelFields.length; i++) {
			infoLabelFields[i] = new JTextField();
			infoLabelFields[i].setEditable(false);
		}
		
		bigFont = new Font(infoLabels[0].getFont().getFontName(), Font.BOLD, 16);
		
		infoLabels[0] = new JLabel(" Connection Information", JLabel.LEFT);
		infoLabels[0].setFont(bigFont);
		
		addC(info, infoLabels[0], 0, 0, 2, 0);
		
		for(int i = 1; i < infoLabels.length-1; i++) {
			addC(info, infoLabels[i], 0, i, 0, 0);
			//addC(info, infoLabelFields[i], 1, i, 1, 0);
		}
		
		infoLabels[1].setText(" Client Alias: " + clientAlias);
		infoLabels[2].setText(" Client IP-Address: " + clientIP);
		infoLabels[3].setText(" Connected to port: " + 1234);
		infoLabels[4].setText(" Client Session ID: " + clientSessionID);
		infoLabels[5].setText(" Client action history: ");
		
		addC(info, infoLabels[5], 0, 5, 1, 0);
		clientHistory = new JScrollPane(infoLabelFields[0]);
		addC(info, clientHistory, 0, 6, 3, 50);
	}
	
	private void addC(JComponent comp1, JComponent comp, int gridx, int gridy, int gridwidth, int ipady) {
		c.gridx = gridx; 
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.ipady = ipady;
		c.weightx = c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		comp1.add(comp, c);
	}
	
	private void setInformationFields(String alias, String IP, int port, String type) {
		infoLabels[1].setText(" Client Alias: " + clientAlias);
		infoLabels[2].setText(" Client IP-Address: " + clientIP);
		infoLabels[3].setText(" Connected to port: " + 1234);
		infoLabels[4].setText(" Client Session ID: " + clientSessionID);
		
		infoLabelFields[1].setText(alias);
		infoLabelFields[2].setText(IP);
		infoLabelFields[3].setText(String.valueOf(port));
		infoLabelFields[4].setText(type);
	}

	private void clearInformationFields() {
		for(int i = 0; i < infoLabelFields.length; i++) {
			infoLabelFields[i].setText("");
		}
	}
	
	private void addPanels() {
		this.add(pane);
		this.add(info);
		this.validate();
	}
	
	@Override
	public void setDefaultProperties() {
		this.setLayout(new GridLayout(1, 2));
		this.setVisible(true);
	}
	
	@Override
	public void addContent() {
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void mousePressed(MouseEvent e) {
		selectedClient = ((JList)e.getSource()).getSelectedValue().toString();
		String[] BOBROSS = ((JList)e.getSource()).getSelectedValue().toString().split("/");
		System.out.println(java.util.Arrays.toString(BOBROSS));
		clientSessionID = BOBROSS[0];
		clientAlias = BOBROSS[1];
		clientIP = BOBROSS[2];
		setInformationFields(clientAlias, clientIP, ServerMainFrame.portNumber, "User");
		chatArea.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// DISCONNECT BUTTON
		if(e.getSource() == actionButtons[0]) {
			//System.out.println(clientUserNo);
			TCPServer.getAllConnections().get(clientSessionID).disconnectClient();
			model.removeElement(selectedClient);
			clearInformationFields();
			TCPServer.userCount--;
		}
		// SEND MESSAGE BUTTON
		if(e.getSource() == send) {
			String message = chatMessage.getText();
			TCPServer.getAllConnections().get(clientSessionID).sendMessage(message);
			chatArea.append("[SERVER]" + message + "\n");
			chatMessage.setText("");
			this.validate();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public static void addElementToList(String x) {
		model.addElement(x);
	}
	
	public static void removeElementFromList(String x) {
		model.removeElement(x);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
