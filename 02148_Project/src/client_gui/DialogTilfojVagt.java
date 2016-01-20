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
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class DialogTilfojVagt extends JDialog implements GeneralProperties, ActionListener, MouseListener {
    private MainFrame parent;
    private GridBagConstraints c = new GridBagConstraints();
    private JPanel panel = new JPanel(new GridBagLayout());
    private JLabel JLDato,JLTilfojVagt, JLOpgaveTitel, JLAdresse, JLPostnummer, JLStarttid;
    private JTextField JTOpgaveTitel, JTAdresse, JTPostnummer, JTStarttid;
    private JButton JBTilfoj, JBAnnuller;
    private String dato, tid, jobNavn, jobAdresse, postnummer, newJob, sessionID;
    private JFormattedTextField JTDato, JTStarttid1;
   
    private Panel3Kalender p3Kalender = new Panel3Kalender(parent);
   
    public  DialogTilfojVagt(MainFrame parent){
        this.parent = parent;
        setJComponents();
        setDefaultProperties();
       
        int i = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        addC(JLTilfojVagt,i,0,3);c.insets = new Insets(10,4,2,0);
        addC(JLDato,i,1,1); c.insets = new Insets(2,4,2,0);
        addC(JTDato,i,2,1);i++; c.insets = new Insets(10,1,2,0);
        addC(JLStarttid,i,1,1);c.insets = new Insets(2,1,2,0);
        addC(JTStarttid,i,2,1);i++;c.insets = new Insets(10,1,2,0);
        addC(JLOpgaveTitel,i,1,1);c.insets = new Insets(1,2,2,0);
        addC(JTOpgaveTitel,i,2,1);i++;c.insets = new Insets(10,1,2,0);
        addC(JLAdresse,i,1,1);c.insets = new Insets(2,2,2,0);
        addC(JTAdresse,i,2,1);i++;c.insets = new Insets(10,1,2,0);
        addC(JLPostnummer,i,1,3);c.insets = new Insets(2,1,2,4);
        addC(JTPostnummer,i,2,3);c.insets = new Insets(10,1,2,4);
       
        c.anchor = GridBagConstraints.EAST;
        c.fill = GridBagConstraints.NONE;
        addC(JBAnnuller,i-1,3,1);i++;
        c.fill = GridBagConstraints.HORIZONTAL;
        addC(JBTilfoj,i,3,1);
       
        JTPostnummer.addActionListener(this);
        JBTilfoj.addMouseListener(this);
        JBAnnuller.addMouseListener(this);
       
        this.add(panel);
        this.pack();
           
    }
   
    private void addC(JComponent comp, int x, int y, int width){
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        panel.add(comp,c);
        panel.validate();
    }
   
    private void setJLabel(JLabel name){
        name.setFont(new Font("SanSerif", Font.PLAIN,14));
        name.setVisible(true);
    }
   
    private void setJTextField(JTextField name){
        name.setFont(new Font("SanSerif", Font.PLAIN,14));
        name.setVisible(true);
    }
   
    private void setJButton(JButton name){
        name.setFont(new Font("SanSerif", Font.PLAIN,14));
        name.setVisible(true);
    }
   
    private void setJComponents(){
        JTDato = new JFormattedTextField(new java.util.Date());
        JLDato = new JLabel("Dato");
        JLTilfojVagt = new JLabel("<HTML><U> Tilføj Vagt <U> </HTML>");
        JLTilfojVagt.setFont(new Font("SanSerif",Font.PLAIN,25));
        JLOpgaveTitel = new JLabel("Opgave Titel");
        JLAdresse = new JLabel("Adresse");
        JLPostnummer = new JLabel("Postnummer");
        JLStarttid = new JLabel("Starttid");       
        JTOpgaveTitel = new JTextField(22);
        JTAdresse = new JTextField(22);
        JTPostnummer = new JTextField(4);
        JTStarttid = new JTextField(6);
        JBTilfoj = new JButton("Tilføj");
        JBAnnuller = new JButton("Annuller");
        setJLabel(JLOpgaveTitel);
        setJLabel(JLAdresse);
        setJLabel(JLPostnummer);
        setJLabel(JLStarttid);
        setJTextField(JTDato);
        setJTextField(JTOpgaveTitel);
        setJTextField(JTAdresse);
        setJTextField(JTPostnummer);
        setJTextField(JTStarttid);
        setJButton(JBTilfoj);
        setJButton(JBAnnuller);
    }
   
    private void setDefaultProperties(){
        this.setUndecorated(true);
        this.setPreferredSize(new Dimension(KalenderDimension.width+50,150));
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);     
    }
   
    private String getNewJob(){
        dato = JTDato.getText();
        tid = JTStarttid.getText();
        jobNavn = JTOpgaveTitel.getText();
        jobAdresse = JTAdresse.getText();
        postnummer = JTPostnummer.getText();
        sessionID = MainFrame.client.getSessionID();
        newJob = "A15." + dato + "." + tid + "." + jobNavn + "." + jobAdresse + "." + postnummer + "." + sessionID;
        return newJob;
    }
   
    private void tilfojVagt(){
        MainFrame.client.sendMessage(getNewJob());;
        System.out.println(dato);
        MainFrame.panel2.p3Kalender.addCalendarTask(dato, tid, jobNavn, jobAdresse, postnummer);
        parent.setFocusable(true);
        dispose();
    }
   
    private void fieldsEmpty(){
        getNewJob();
        if (!dato.isEmpty() && !tid.isEmpty() && !jobNavn.isEmpty() && !jobAdresse.isEmpty() && !postnummer.isEmpty()){
            tilfojVagt();
        }
        else{
            DialogBesked DBesked = new DialogBesked(parent, "Udfyld alle felter");
            DBesked.setAlwaysOnTop(true);
            DBesked.setVisible(true);
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JTPostnummer){
            fieldsEmpty();
        }      
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == JBTilfoj){
            fieldsEmpty();
        }
        if (e.getSource() == JBAnnuller){
 
            parent.setFocusable(true);
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
 
}