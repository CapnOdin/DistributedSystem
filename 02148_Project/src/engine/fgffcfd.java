package engine;

import java.awt.Dimension;

import javax.swing.JFrame;

public class fgffcfd {
	
	private JFrame frame = new JFrame();
	
	public fgffcfd() {
		
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(400,400));
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new fgffcfd();
	}
	
}
