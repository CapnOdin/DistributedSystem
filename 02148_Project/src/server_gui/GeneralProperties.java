package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public interface GeneralProperties {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public Dimension frameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);
	//public Dimension labelSize = new Dimension((screenSize.getContentPane().getWidth()), (frameSize.height/10*2));
	public Color bg_color = Color.white;
	
}
