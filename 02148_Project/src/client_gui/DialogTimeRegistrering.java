package client_gui;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class DialogTimeRegistrering extends JDialog implements ActionListener, MouseListener{
    private MainFrame parent;
    private JPanel panel = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JLabel JLTimeRegistrering,JLNavn, JLStarttid, JLSluttid,JLPause;
    private JTextField JTNavn, JTStarttid, JTSluttid, JTPause;
    private JButton JBGem, JBAnuller;
    private String dato, tid, navn, adresse, postnummer,starttid, sluttid, pause;
   
    public DialogTimeRegistrering(MainFrame parent, String dato, String tid, String navn, String adresse, String postnummer){
        this.parent = parent;
        this.dato = dato;
        this.tid = tid;
        this.navn = navn;
        this.adresse = adresse;
        this.postnummer = postnummer;
        setDefaultProperties();
        setJComponents();
       
        int i = 1;
        addC(JLTimeRegistrering,0,0,3,0);
        addC(JLNavn,i,1,1,200);
        addC(JTNavn,i,2,1,200);i++;
        addC(JLStarttid,i,1,1,20);
        addC(JTStarttid,i,2,1,20);i++;
        addC(JLSluttid,i,1,1,20);
        addC(JTSluttid,i,2,1,20);
        addC(JBAnuller,i,3,1,20);i++;
        addC(JLPause,i,2,1,20);
        addC(JTPause,i,2,1,20);
        addC(JBGem,i,3,1,20);
       
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
        JLNavn = new JLabel("Opgave Navn");
        JLStarttid = new JLabel("Starttid");
        JLSluttid = new JLabel("Sluttid");
        JLPause = new JLabel("Pause");
        JTNavn = new JTextField(navn);
        JTStarttid = new JTextField(4);
        JTSluttid = new JTextField(4);
        JTPause = new JTextField("00:00");
        JBGem = new JButton("Gem");
        JBAnuller = new JButton("Anuller");
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
        pause = JTPause.getText();
        return "A14." + dato + "." + navn + "."+ adresse + "." + postnummer + "." + starttid + "." + sluttid + "." + pause + "."+ MainFrame.client.getSessionID();
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