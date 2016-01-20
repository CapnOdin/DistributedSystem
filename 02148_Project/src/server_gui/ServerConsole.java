package server_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class ServerConsole extends ServerPanelTemplate {

	private static final long serialVersionUID = 1L;
	
	private JTextArea consolePane;
	private JScrollPane scrollPane;
	
	public ServerConsole(ServerMainFrame parent, String ID) {
		super(parent, ID);
	}
	
	@Override
	public void setDefaultProperties() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
	}

	@Override
	public void addContent() {
		consolePane = new JTextArea();
		consolePane.setBackground(panelColor);
		consolePane.setForeground(Color.white);
		consolePane.setEditable(false);
		PrintStream out = new PrintStream(new TextAreaOutputStream(consolePane));
		System.setOut(out);
		System.setErr(out);
		scrollPane = new JScrollPane(consolePane);
		DefaultCaret caret = (DefaultCaret)consolePane.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private class TextAreaOutputStream extends OutputStream {
		private JTextArea console;
		
		public TextAreaOutputStream(JTextArea console) {
			this.console = console;
		}
		
		@Override
		public void write(int b) throws IOException {
			console.append( String.valueOf( ( char )b ) );
			
		}
		
	}

}
