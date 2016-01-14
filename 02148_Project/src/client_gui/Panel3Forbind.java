package client_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel3Forbind extends PanelTemplate implements GeneralProperties, ActionListener, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail, JTKodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	private String clientData, email, connectInfo, kodeord;
	private String[] array, array1;
	
	public Panel3Forbind(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		int space = 2;
		int spaceTop = 40;
		int spaceSTD = 4;
		int spaceExtra = 20;
		
		
		// Insets = Top, Venstre, Bund, Højre
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.BOTH;
		addC(JLForbind,			0,	i,	1,	1,		new Insets(spaceTop,			space,	2,	space));i++;
		addC(JLEMail,			0,	i,	1,	1,		new Insets(spaceExtra,			space,	0,	space));i++;c.ipadx = 450;
		addC(JTEMail,			0,	i,	1,	1,		new Insets(spaceSTD,			space,	0,	space));i++;c.ipadx = 0;
		addC(JLKodeord,			0,	i,	1,	1,		new Insets(spaceExtra,			space,	0,	space));i++;
		addC(JTKodeord,			0,	i,	1,	1,		new Insets(spaceSTD,			space,	0,	space));i++;
		addC(JCGemOplysninger,	0,	i,	1,	1,		new Insets(spaceExtra,			space,	0,	space));i++;
		addC(JBForbind,			0,	i,	1,	1,		new Insets(spaceSTD,			space,	200,	space));i++;
		
		JTKodeord.addActionListener(this);
		JBForbind.addMouseListener(this);
		panel.setBackground(Color.white);
		this.add(panel);
		this.setVisible(true);

		System.out.println(panel.getWidth());
	}
	
	@Override
	void setDefaultProperties() {
		this.setBackground(Color.white);
		this.setPreferredSize(frameSizePanel3);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		this.validate();
	}
	
	private void addC(JComponent comp, int gridx, int gridy, int gridwidth, int gridheight, Insets space) {
		c.insets = space;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		panel.add(comp, c);
		panel.validate();
	}
	
	private void setJTextField(JTextField name){
		name.setFont(new Font("SansSerif", Font.ITALIC, 14));
		name.setVisible(true);
	}
	
	private void setJLabel(JLabel name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);		
	}
	
	private void setJCheckBox(JCheckBox name){
		name.setFont(new Font("SansSerif", Font.PLAIN, 14));
		name.setVisible(true);
	}
	
	private void setJComponents(){
		JLForbind = new JLabel("<HTML> <U>Forbind bruger med Moment konto</U></HTML>"); 
		JLEMail = new JLabel("E-Mail");
		JLKodeord = new JLabel("Kodeord");
		JTEMail = new JTextField(getEMail());
		JTKodeord = new JTextField();
		JCGemOplysninger = new JCheckBox("Gem oplysninger");
		JBForbind = new JButton("Forbind");
		JLForbind.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLForbind.setVisible(true);
		setJLabel(JLEMail);
		setJLabel(JLKodeord);
		setJTextField(JTEMail);
		setJTextField(JTKodeord);
		setJCheckBox(JCGemOplysninger);
		setJButton(JBForbind);
	}
	
	private String getEMail(){
		// Senere: Hent clientdata direkte fra server
		clientData = "Lise.projekt.Lise Andersen.Grønnehøj 39.2720.Vanløse.Lise_Noerby@hotmail.com.1";
		
		array = clientData.split("\\.");
		email = array[6];
		return email;
	}
	
	private void getConnectInfo(){
		// Senere: Hent ConnectInfo direkte fra serveren tilsvarende email
		connectInfo = "Lise_Noerby@hotmail.com.projekt";
		array1 = connectInfo.split("\\.");
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBForbind){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(frameSizePanel3);
		JFrame test = new JFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setPreferredSize(frameSizePanel3);
		test.setVisible(true);
		test.pack();
		test.setLocationRelativeTo(null);
		
		test.add(new Panel3Connect());
		test.validate();
	}
	*/
}
