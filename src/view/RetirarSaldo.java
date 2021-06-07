package view;

import javax.swing.JButton;

public class RetirarSaldo extends PanelGenerico {

	private JButton btnSalir;

	public RetirarSaldo() {
		super();
		getTxtMostrar().setLocation(10, 95);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(149, 48, 89, 23);
		add(btnSalir);
	}

	public JButton getBtnSalir() {
		return this.btnSalir;
	}

}
