package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public interface GeneralProperties {
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Dimension frameSize = new Dimension((screenSize.width / 4)*3, (screenSize.height / 4)*3);
	public static Dimension frameSizeDP1 = new Dimension(frameSize.width,frameSize.height/20);
	public static Dimension frameSizeDP2 = new Dimension( frameSize.width, (frameSize.height/20)*2);
	public static Dimension frameSizeDP3 = new Dimension(frameSize.width, (frameSize.height/20)*17);
	public static Color bg_color = Color.white;
}
