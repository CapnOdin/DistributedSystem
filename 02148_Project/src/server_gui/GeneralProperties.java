package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GeneralProperties {
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Dimension frameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);
	public static Color bg_color = Color.white;
}
