package model;

import javax.swing.JOptionPane;



public class Usuario {
	private int id;
	private String nombres;
	private String apellidos;
	private String contrasena;
	private float saldo_actual;
	private float saldo_actual_bkp;

	public Usuario() {

	}

	public Usuario(int id, String contrasena) {
		this.id = id;
		this.contrasena = contrasena;
	}

	public Usuario(int id, String nombres, String apellidos, String contrasena, float saldo_actual) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.saldo_actual = saldo_actual;
	}

	public int getID() {
		return this.id;
	}

	public String getNombres() {
		return this.nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public float getSaldo() {
		return this.saldo_actual;
	}

	public boolean restarSaldo(float cantidad_retirar) {
		if (this.saldo_actual >= cantidad_retirar) {
			this.saldo_actual -= cantidad_retirar;
			return true;
		} else {
			return false;
		}

	}

	public boolean consignarSaldo(float cantidad_consignada) {
		if (cantidad_consignada > 0) {
			this.saldo_actual += cantidad_consignada;
			return true;
		} else {
			return false;
		}

	}

	public void setUsuario(Usuario u) {
		this.id = u.id;
		this.nombres = u.nombres;
		this.apellidos = u.apellidos;
		this.contrasena = u.contrasena;
		this.saldo_actual = u.saldo_actual;

	}

	public void restablecer() {
		this.saldo_actual = this.saldo_actual_bkp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(this.nombres);
		sb.append(" ");
		sb.append(this.apellidos);
		return sb.toString();
	}
	

}
