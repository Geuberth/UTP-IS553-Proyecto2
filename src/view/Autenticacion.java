package view;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Billetes;


public class Autenticacion extends PanelGenerico {

	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnContinuar;
	private Billetes bill;
	public Autenticacion() {
		super();
		getTxtMostrar().setLocation(10, 157);
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 36, 238, 20);
		this.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(10, 92, 238, 20);
		this.add(txtContrasena);
		txtContrasena.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 238, 14);
		this.add(lblUsuario);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(10, 67, 238, 14);
		this.add(lblContrasena);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(10, 123, 142, 23);
		this.add(btnContinuar);
	}

	public String getUsuario() {
		return this.txtUsuario.getText();
	}

	public String getContrasena() {
		return this.txtContrasena.getText();
	}
	
	public JButton getBtnContinuar() {
		return this.btnContinuar;
	}

	public void setTxtUsuario(String string) {
		this.txtUsuario.setText(string);
	}

	public void setTxtContrasena(String string) {
		this.txtContrasena.setText(string);
	}
	
}
