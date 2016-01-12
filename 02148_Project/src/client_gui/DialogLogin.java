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

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogLogin extends JDialog implements ActionListener, MouseListener{
	private MainFrame parent;
    private GridBagConstraints c = new GridBagConstraints();
	private JTextField JTBrugernavn;
    private JPasswordField Kodeord;
    private JLabel JLBrugernavn;
    private JLabel JLKodeord;
    private JButton JBLogin;
    private JLabel JLNyBruger;
    private JButton JBAnnuller;
    private boolean succeeded;
    private boolean nyBruger = false;
    
    private DialogNyBruger DNyBruger;
      
    public DialogLogin(MainFrame parent) {
        super(parent, "Login", true);
        setDefaultProperties();
        setJComponents();

        int i = 0;
        addC(JLBrugernavn, 0,i,1);i++;
        addC(JTBrugernavn,0,i,2);i++;
        addC(JLKodeord,0,i,1);i++;
        addC(Kodeord,0,i,2);i++;
        c.insets = new Insets(10,0,0,0);
        addC(JLNyBruger,0,i,1);i++;
        c.insets = new Insets(2,0,0,0);
        addC(JBLogin,0,i,1);
        addC(JBAnnuller,1,i,1);
        
        Kodeord.addActionListener(this);
        JBLogin.addMouseListener(this);
        JLNyBruger.addMouseListener(this);
        JBAnnuller.addMouseListener(this);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    private void addC(JComponent comp, int x, int y, int width){
    	c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		this.add(comp, c);
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
	
	private void setJComponents(){
        JLBrugernavn = new JLabel("Brugernavn: ");
        JTBrugernavn = new JTextField(20);
        JLKodeord = new JLabel("Kodeord: ");
        Kodeord = new JPasswordField(20);
        JBLogin = new JButton("Log ind");
        JLNyBruger = new JLabel("<HTML><U>Ny bruger</U></HTML>");
        JLNyBruger.setForeground(Color.blue);
        JBAnnuller = new JButton("Annuller");
        setJTextField(JTBrugernavn);
        setJTextField(Kodeord);
        setJLabel(JLBrugernavn);
        setJLabel(JLKodeord);
        setJButton(JBLogin);
        setJLabel(JLNyBruger);
        setJButton(JBAnnuller);
	}
	
    private void setDefaultProperties(){
    	this.setUndecorated(true);
    	this.setPreferredSize(new Dimension(500,200));
    	this.setLayout(new GridBagLayout());
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == Kodeord){
			if (Login.authenticate(getUsername(), getPassword())) {
                this.setVisible(false);
                succeeded = true;
                dispose();
            } else {
            	Object[] options = { "Glemt kodeord","Prøv igen", "Opret ny bruger"};
            	int n = JOptionPane.showOptionDialog(parent, "Ugyldigt login", "Fejl",
            			JOptionPane.YES_NO_OPTION,
            			JOptionPane.WARNING_MESSAGE,
            			null,     //do not use a custom Icon
            			options,  //the titles of buttons
            			options[0]); //default button title
                succeeded = false;
            }
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBLogin){
			if (Login.authenticate(getUsername(), getPassword())) {
                this.setVisible(false);
                succeeded = true;
                dispose();
            } else {
            	Object[] options = { "Glemt kodeord","Prøv igen", "Opret ny bruger"};
            	int n = JOptionPane.showOptionDialog(parent, "Ugyldigt login", "Fejl",
            			JOptionPane.YES_NO_OPTION,
            			JOptionPane.WARNING_MESSAGE,
            			null,     //do not use a custom Icon
            			options,  //the titles of buttons
            			options[0]); //default button title
                succeeded = false;
            }
		}
		if (e.getSource() == JLNyBruger){	
			DNyBruger = new DialogNyBruger(parent);		
		    this.setVisible(false);
		    DNyBruger.setVisible(true);
			//dispose();
		}
		if (e.getSource() == JBAnnuller){
			System.exit(0);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
    
    public String getUsername() {
        return JTBrugernavn.getText().trim();
    }
 
    public String getPassword() {
        return new String(Kodeord.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }

    public boolean NyBruger(){
    	return nyBruger;
    }
    
}
