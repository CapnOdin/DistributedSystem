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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogTilfojVagt extends JDialog implements GeneralProperties, ActionListener, MouseListener {
	private MainFrame parent;
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel panel = new JPanel(new GridBagLayout());
	private JLabel JLTilfojVagt, JLDato, JLOpgaveTitel, JLAdresse, JLPostnummer, JLStarttid;
	private JTextField JTDato, JTOpgaveTitel, JTAdresse, JTPostnummer, JTStarttid;
	private JButton JBTilfoj, JBAnnuller;
	
	public  DialogTilfojVagt(MainFrame parent){
		this.parent = parent;
		setDefaultProperties();
		setJComponents();
		
		
		int i = 0;
		c.anchor = GridBagConstraints.NORTHWEST;
		addC(JLTilfojVagt,i,0,1);c.insets = new Insets(10,4,2,0);
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
		
		JTStarttid.addActionListener(this);
		JBTilfoj.addMouseListener(this);
		JBAnnuller.addMouseListener(this);
		
		this.add(panel);
		this.pack();
		this.setModal(true);
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
		JLTilfojVagt = new JLabel("<HTML><U> Tilføj Vagt <U> </HTML>");
		JLTilfojVagt.setFont(new Font("SanSerif",Font.PLAIN,25));
		JLDato = new JLabel("Dato");
		JLOpgaveTitel = new JLabel("Opgave Titel");
		JLAdresse = new JLabel("Adresse");
		JLPostnummer = new JLabel("Postnummer");
		JLStarttid = new JLabel("Starttid");
		JTDato = new JTextField(8);
		JTOpgaveTitel = new JTextField(26);
		JTAdresse = new JTextField(25);
		JTPostnummer = new JTextField(7);
		JTStarttid = new JTextField(8);
		JBTilfoj = new JButton("Tilføj");
		JBAnnuller = new JButton("Annuller");
		setJLabel(JLDato);
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
		this.setPreferredSize(new Dimension(JTextAreaDimension.width+20,150));
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JTStarttid){
			dispose();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == JBTilfoj){
			dispose();
		}
		if (e.getSource() == JBAnnuller){
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
