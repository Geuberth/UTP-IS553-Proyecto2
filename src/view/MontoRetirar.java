package view;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MontoRetirar extends PanelGenerico {
	private JTextField txtMontoRetirar;
	private JButton btnContinuar;
	
	public MontoRetirar() {
		getTxtMostrar().setLocation(10, 134);
		
		txtMontoRetirar = new JTextField();
		txtMontoRetirar.setBounds(10, 65, 388, 20);
		add(txtMontoRetirar);
		txtMontoRetirar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Monto a retirar:");
		lblNewLabel.setBounds(10, 40, 151, 14);
		add(lblNewLabel);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(10, 100, 122, 23);
		add(btnContinuar);

	}
	
	public String getTxtMontoRetirar() {
		return txtMontoRetirar.getText();
	}

	public JButton getBtnContinuar() {
		return this.btnContinuar;
	}
	
}
