package view;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Contenedor {

	private JFrame frame;
	private JPanel actualPanel;
	
	public Contenedor() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	public void setVisible(boolean ver) {
		this.frame.setVisible(ver);
	}
	
	public JPanel getPanel() {
		return this.actualPanel;
	}
	
	public void changeWindow(JPanel newWindow) {
		frame.getContentPane().removeAll();
		this.actualPanel = newWindow;
		frame.getContentPane().add(this.actualPanel);
		frame.getContentPane().repaint();		
	}

}
