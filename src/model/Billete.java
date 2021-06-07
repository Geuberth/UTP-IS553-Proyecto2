package model;

public class Billete {
	private int id;
	private String nominacion;
	private int cantidad;

	public Billete(int id, String nominacion, int cantidad) {
		this.id = id;
		this.nominacion = nominacion;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public String getNominacion() {
		return this.nominacion;
	}
	
	public boolean disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
		return true;
	}

}
