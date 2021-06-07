package view;

import javax.swing.JButton;

public class Principal extends PanelGenerico {

	private JButton btnConsultarSaldo;
	private JButton btnRetirar;

	public Principal() {
		super();
		getTxtMostrar().setLocation(10, 92);
		btnConsultarSaldo = new JButton("Consultar saldo");

		btnConsultarSaldo.setBounds(10, 27, 162, 23);
		this.add(btnConsultarSaldo);

		btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(236, 27, 162, 23);
		this.add(btnRetirar);

	}

	public JButton getBtnConsultarSaldo() {
		return this.btnConsultarSaldo;
	}

	public JButton getBtnRetirar() {
		return this.btnRetirar;
	}
}
