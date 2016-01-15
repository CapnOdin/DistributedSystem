package client_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public interface GeneralProperties {
	
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Dimension frameSize = new Dimension((screenSize.width / 3)*2, (screenSize.height / 4)*3);
	public static Dimension frameSizePanel1 = new Dimension(frameSize.width, (frameSize.height-25) / 20);
	public static Dimension frameSizePanel2 = new Dimension(frameSize.width, (frameSize.height-25) *2/20);
	
	public static double extra = (frameSize.height - (frameSize.height-25)/20 - (frameSize.height-25) *2/20 - (frameSize.height-25) *16/ 20);
	
	//public static Dimension frameSizePanel3 = new Dimension(frameSize.width, ((frameSize.height-25) / 20)*16+26); 
	public static Dimension frameSizePanel3 = 	new Dimension(frameSize.width, ((frameSize.height-25) *16/ 20)+30);
	public static Dimension JTextAreaDimension = new Dimension(frameSizePanel3.width*18/20,frameSizePanel3.height *8/10);										 
}
