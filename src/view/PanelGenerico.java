package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PanelGenerico extends JPanel {

	private JTextPane txtMostrar;

	public PanelGenerico() {
		this.setBounds(100, 100, 690, 521);
		this.setLayout(null);
		txtMostrar = new JTextPane();
		txtMostrar.setEditable(false);
		txtMostrar.setBounds(10, 192, 388, 143);
		this.add(txtMostrar);
	}

	public void addActionListener(JButton btn, ActionListener action) {
		this.remove(btn);
		btn.addActionListener(action);
		this.add(btn);
	}
	
	public JTextPane getTxtMostrar() {
		return this.txtMostrar;
	}
	
	public void setMostrar(String texto) {
		this.txtMostrar.setText(texto);
	}
}
