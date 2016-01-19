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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Panel3Forbind extends JPanel implements GeneralProperties, ActionListener, MouseListener{
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLForbind, JLEMail, JLKodeord;
	private JTextField JTEMail;
	private JPasswordField Kodeord;
	private JCheckBox JCGemOplysninger;
	private JButton JBForbind;
	private String clientData, email, connectInfo, kodeord, sessionID;
	private String[] array, array1;
	
	private DialogBesked DBesked;
	
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
		addC(JLEMail,			0,	i,	1,	1,		new Insets(spaceExtra,			space,	0,	space));i++;c.ipadx = 480;
		addC(JTEMail,			0,	i,	1,	1,		new Insets(spaceSTD,			space,	0,	space));i++;c.ipadx = 0;
		addC(JLKodeord,			0,	i,	1,	1,		new Insets(spaceExtra,			space,	0,	space));i++;
		addC(Kodeord,			0,	i,	1,	1,		new Insets(spaceSTD,			space,	0,	space));i++;
		addC(JBForbind,			0,	i,	1,	1,		new Insets(spaceExtra,			space,	200,	space));i++;
		
		Kodeord.addActionListener(this);
		JBForbind.addMouseListener(this);
		panel.setBackground(Color.white);
		this.add(panel);
		this.setVisible(true);
	}
	
	private void setDefaultProperties() {
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
		JTEMail = new JTextField(parent.profile.eMail);
		Kodeord = new JPasswordField();
		JBForbind = new JButton("Forbind");
		JLForbind.setFont(new Font("SansSerif", Font.PLAIN, 20));
		JLForbind.setVisible(true);
		setJLabel(JLEMail);
		setJLabel(JLKodeord);
		setJTextField(JTEMail);
		setJTextField(Kodeord);
		setJButton(JBForbind);
	}
	
	private String getConnectInfo(){
		email = JTEMail.getText();
		kodeord = Kodeord.getText();
		sessionID = MainFrame.client.getSessionID();
		connectInfo = "A6."+ email + "." + kodeord + "." + sessionID;
		return connectInfo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == JBForbind){
			forbind();			
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
		if (e.getSource() == Kodeord){
			forbind();
		}
		
	}
	
	private void forbind(){
		if (!Kodeord.getText().isEmpty()){
			if (false){		
				System.out.println(email);
				System.out.println(kodeord);
				try {
					String[] var = api.MomentApi.loginMoment(email,kodeord);
					System.out.println(var[1]);
					api.MomentApi.getVagter("2016-01-01",var[0]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else{
				DBesked = new DialogBesked(parent, parent.msg[2]);
				DBesked.setAlwaysOnTop(true);
				DBesked.setVisible(true);
			}
		}
	}
}
