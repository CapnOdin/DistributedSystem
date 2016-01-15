package server_gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ServerBlurGlass extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private JFrame f;
    
    public ServerBlurGlass(JFrame f) {
        this.f = f;
        setOpaque(false);
        setFocusable(false);
        addMouseListener(new MouseAdapter(){});
        addMouseMotionListener(new MouseMotionAdapter(){});
    }
    
    public void paintComponent(Graphics g) {
        int w = f.getWidth();
        int h = f.getHeight();
        setLocation(0,0);
        setSize(w,h);
        g.setColor(new Color(0,0,0,.9f));
        g.fillRect(0,0,w,h);
    }
}