package view;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class ConsultarSaldo extends PanelGenerico {

	JButton btnSalir;
	JButton btnRetirar;

	public ConsultarSaldo() {
		super();
		getTxtMostrar().setLocation(10, 113);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(309, 61, 89, 23);
		this.add(btnSalir);

		btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(10, 61, 89, 23);
		this.add(btnRetirar);
	}

	public JButton getBtnSalir() {
		return this.btnSalir;
	}

	public JButton getBtnRetirar() {
		return this.btnRetirar;
	}
}
