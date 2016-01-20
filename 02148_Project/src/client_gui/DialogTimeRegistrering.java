package client_gui;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import client_eng.TCPClient;
 
public class DialogTimeRegistrering extends JDialog implements ActionListener, MouseListener{
    private MainFrame parent;
    private JPanel panel = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JLabel JLTimeRegistrering,JLNavn, JLStarttid, JLSluttid,JLPause;
    private JTextField JTNavn, JTStarttid, JTSluttid, JTPause;
    private JButton JBGem, JBAnuller;
    private String dato, tid, navn, adresse, postnummer,starttid, sluttid, pause, start;
   
    public DialogTimeRegistrering(MainFrame parent, String dato, String tid, String navn, String adresse, String postnummer, String start){
        this.parent = parent;
        this.dato = dato;
        this.tid = tid;
        this.navn = navn;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.start = start;
        setDefaultProperties();
        setJComponents();
       
        int i = 0;
        c.insets = new Insets(0,20,0,0);
        addC(JLTimeRegistrering,0,0,1,0);
        c.ipady = 20;
        addC(JLNavn,i,1,1,160);
        c.ipady = 0;
        addC(JTNavn,i,2,1,160);i++;
        c.insets = new Insets(0,0,0,0);
        addC(JLPause,i,1,1,20);
        addC(JTPause,i,2,1,20);i++;
        addC(JLStarttid,i,1,1,0);
        addC(JTStarttid,i,2,1,0);
        addC(JBAnuller,i,3,1,0);i++;
        c.insets = new Insets(0,0,0,20);
        addC(JLSluttid,i,1,1,0);
        addC(JTSluttid,i,2,1,0);
        addC(JBGem,i,3,1,0);
       
        this.add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
   
    private void setDefaultProperties(){
        this.setUndecorated(true);
        this.setPreferredSize(new Dimension(500,150));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
   
    private void setJComponents(){
    	JLTimeRegistrering = new JLabel("<HTML><U> Time Registrering<U> </HTML>");
        JLTimeRegistrering.setFont(new Font("SanSerif",Font.PLAIN,25));
        try {
			JTStarttid = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
		}
        try {
			JTSluttid = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
		}
        try {
			JTPause = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
		}
		JTStarttid.setText(tid);
		JTPause.setText("00:00");
        JTNavn = new JTextField(navn);
        JLNavn = new JLabel("Opgave Navn");
        JLStarttid = new JLabel("Starttid");
        JLSluttid = new JLabel("Sluttid");
        JLPause = new JLabel("Pause");
        JBGem = new JButton("Gem");
        JBAnuller = new JButton("Anuller");
        JTNavn.setEditable(false);
        JBGem.addMouseListener(this);
        JTPause.addActionListener(this);
        JBAnuller.addMouseListener(this);
    }
   
    private void addC(JComponent comp, int x, int y, int width, int width1){
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.ipadx = width1;
        panel.add(comp, c);
    }
   
    private String getJob(){
        starttid = JTStarttid.getText();
        sluttid = JTSluttid.getText();
        MainFrame.profile.calendar.edit_job(start, "StartTime", starttid);
        MainFrame.profile.calendar.edit_job(start, "EndTime", sluttid);
        MainFrame.profile.archive_job(start);
        pause = JTPause.getText();
        return "A14." + dato + "." + navn + "."+ adresse + "." + postnummer + "." + starttid + "." + sluttid + "." + pause + "."+ TCPClient.getSessionID();
    }
   
    private void addJob(){
        getJob();
        if (!starttid.isEmpty() && !sluttid.isEmpty() && !pause.isEmpty()){
            MainFrame.client.sendMessage(getJob());
            if (parent.stallGUI("A7", "TRUE")){
                DialogBesked DBesked = new DialogBesked(parent, "Timer registreret");
                DBesked.setAlwaysOnTop(true);
                DBesked.setVisible(true);
                dispose();
            }
            else{
                DialogBesked DBesked = new DialogBesked(parent, "Timer ikke registreret");
                DBesked.setAlwaysOnTop(true);
                DBesked.setVisible(true);
                dispose();
            }
           
        }
        else{
            DialogBesked DBesked = new DialogBesked(parent, "Udfyld alle felter");
            DBesked.setAlwaysOnTop(true);
            DBesked.setVisible(true);
        }
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == JBGem){
            addJob();
        }
        if(e.getSource() == JBAnuller){
        	dispose();
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
        if (e.getSource() == JTPause){
            addJob();
        }
       
    }
 
}