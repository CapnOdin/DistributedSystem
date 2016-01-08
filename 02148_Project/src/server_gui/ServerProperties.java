package server_gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface ServerProperties {
	public Dimension serverFrameSize = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	public Dimension serverTaskBarSize = new Dimension((int)serverFrameSize.getWidth(), (int)serverFrameSize.getHeight() / 20);
	public Dimension menusPanelSize = new Dimension((int)serverFrameSize.getWidth(), (int)serverFrameSize.getHeight() / 15);
}
