package client_gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogSkiftBillede extends JDialog implements MouseListener {
	private MainFrame parent;
	private JButton JBValg, JBAnnuller, JBGem;
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	public DialogSkiftBillede(MainFrame parent){
		setDefaultProperties();
		setJComponents();
		
		int i = 0;
		addC(JBValg, i,i,1,1); i++;
		addC(JBAnnuller,i,0,1,1);
		addC(JBGem,i,1,1,1);
		
	}
	
	private void addC(JComponent comp, int x, int y, int gridwidth, int gridheight){
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		panel.add(comp, c);
	}
	
	private void setJButton(JButton name){
		name.setFont(new Font("SanfSerif", Font.PLAIN, 14));
		name.setVisible(true);
	}
	
	private void setJComponents(){
		JBValg = new JButton("Vælg");
		JBAnnuller = new JButton("Annuller");
		JBGem = new JButton("Gem");
		setJButton(JBValg);
		setJButton(JBAnnuller);
		setJButton(JBGem);
	}
	
	private void setDefaultProperties(){
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
