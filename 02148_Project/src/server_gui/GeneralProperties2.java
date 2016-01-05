package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GeneralProperties2 {
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Dimension frameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);
	//public Dimension labelSize = new Dimension(MainFrame.frameContentPaneSize.width / 4, (frameSize.height/10*2));
	public static Color bg_color = Color.white;
}
