package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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

public class ServerConnectedClientsPanel extends ServerPanelTemplate implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static DefaultListModel<String> model;
	public static JList<String> allConnections;
	private JScrollPane pane;
	
	private JPanel info;
	private JPanel chat;
	private JScrollPane clientHistory;
	private JPanel infoHolder = new JPanel(new BorderLayout());
	
	private GridBagConstraints c = new GridBagConstraints();
	private JLabel[] infoLabels = new JLabel[6];
	private JTextField[] infoLabelFields = new JTextField[5];
	private Font bigFont;
	
	private JLabel[] chatLabels = new JLabel[2];
	private JTextField chatMessage = new JTextField(50);
	public static JTextArea chatArea = new JTextArea();
	private JScrollPane chatPane = new JScrollPane(chatArea);
	private JButton send = new JButton("Send");
	private JPanel button_holder = new JPanel(new GridLayout(1,4));
	private JButton[] actionButtons = new JButton[4];
	
	private String clientAlias, clientIP, selectedClient;
	private int clientUserNo;
	
	public ServerConnectedClientsPanel(ServerMainFrame parent, String ID) {
		super(parent, ID);
		addInfoPanelContent();
		addChatPanelContent();
		addPanels();
	}

	private void addChatPanelContent() {
		chat = new JPanel(new GridBagLayout());
		chat.setBackground(ServerPanelTemplate.barColor);
		chatArea.setEditable(false);
		
		chatLabels[0] = new JLabel("", JLabel.CENTER);
		chatLabels[0].setText("Actions");
		chatLabels[0].setFont(bigFont);
		addC(chat, chatLabels[0], 0, 0, 3, 1, 0, 0);
		
		chatLabels[1] = new JLabel("Chat:", JLabel.LEFT);
		addC(chat, chatLabels[1], 0, 1, 1, 1, 0, 0);
		
		addC(chat, chatPane, 0, 2, 3, 1, 300, 50);
		addC(chat, chatMessage, 0, 3, 2, 1, 0, 0);
		
		addC(chat, send, 2, 3, 1, 1, 0, 0);
		
		for(int i = 0; i < actionButtons.length; i++) {
			actionButtons[i] = new JButton(""+(i+1)); 
			actionButtons[i].addActionListener(this);
			button_holder.add(actionButtons[i]);
		}
		
		addC(chat, button_holder, 0, 4, 3, 1, 0, 30);
		
		actionButtons[0].setText("Disconnect");
		
		infoHolder.add(chat, BorderLayout.CENTER);
	}

	private void addInfoPanelContent() {
		info = new JPanel(new GridBagLayout());
		info.setBackground(ServerPanelTemplate.barColor);
		
		for(int i = 0; i < infoLabels.length; i++) {
			infoLabels[i] = new JLabel("", JLabel.LEFT);
			infoLabels[i].setText("" + (i+1));
		}
		
		for(int i = 0; i < infoLabelFields.length; i++) {
			infoLabelFields[i] = new JTextField(20);
			infoLabelFields[i].setEditable(false);
		}
		
		bigFont = new Font(infoLabels[0].getFont().getFontName(), Font.BOLD, 18);
		
		infoLabels[0] = new JLabel("Connection Information", JLabel.CENTER);
		infoLabels[0].setFont(bigFont);
		
		addC(info, infoLabels[0], 0, 0, 2, 1, 0, 20);
		
		for(int i = 1; i < infoLabels.length-1; i++) {
			addC(info, infoLabels[i], 0, i, 1, 1, 0, 0);
			addC(info, infoLabelFields[i], 1, i, 1, 1, 0, 0);
		}
		
		infoLabels[1].setText("Client Alias: ");
		infoLabels[2].setText("Client IP-Address: ");
		infoLabels[3].setText("Connected to port: ");
		infoLabels[4].setText("Client Type: ");
		infoLabels[5].setText("Client action history: ");
		
		addC(info, infoLabels[5], 0, 5, 1, 1, 0, 20);
		clientHistory = new JScrollPane(infoLabelFields[0]);
		addC(info, clientHistory, 0, 6, 2, 1, 300, 60);
		
		infoHolder.add(info, BorderLayout.NORTH);
	}
	
	private void addC(JComponent comp1, JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, int ipadx, int ipady) {
		c.gridx = gridx; 
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.fill = GridBagConstraints.HORIZONTAL;
		comp1.add(comp, c);
	}

	private void addPanels() {
		this.add(pane);
		this.add(infoHolder);
		this.validate();
	}

	@Override
	public void addContent() {
		model = new DefaultListModel<String>();
		
		allConnections = new JList<String>(model);
		allConnections.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allConnections.addMouseListener(this);
		allConnections.setBackground(ServerPanelTemplate.barColor);
		
		pane = new JScrollPane(allConnections);
		pane.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void setDefaultProperties() {
		this.setLayout(new GridLayout(1, 2));
		this.setVisible(true);
	}
	
	private void setInformationFields(String alias, String IP, int port, String type) {
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

	@SuppressWarnings("rawtypes")
	@Override
	public void mousePressed(MouseEvent e) {
		selectedClient = ((JList)e.getSource()).getSelectedValue().toString();
		String[] BOBROSS = ((JList)e.getSource()).getSelectedValue().toString().split("/");
		System.out.println(java.util.Arrays.toString(BOBROSS));
		clientUserNo = Integer.parseInt(BOBROSS[0]);
		clientAlias = BOBROSS[1];
		clientIP = BOBROSS[2];
		setInformationFields(clientAlias, clientIP, ServerMainFrame.portNumber, "User");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// DISCONNECT BUTTON
		if(e.getSource() == actionButtons[0]) {
			//System.out.println(clientUserNo);
			TCPServer.getAllConnections().get(clientUserNo).disconnectClient();
			model.removeElement(selectedClient);
			clearInformationFields();
			TCPServer.userCount--;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
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

}
