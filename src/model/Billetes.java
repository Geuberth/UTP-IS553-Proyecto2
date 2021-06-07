package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Billetes {
	private Billete[] listaBilletes;
	private Billete[] listaBilletes_bkp;

	public Billetes() {
		listaBilletes = new Billete[5];

		try (BufferedReader br = Files
				.newBufferedReader(Paths.get("data\\billetes.csv").toAbsolutePath())) {

			boolean ignoreFirstLine = true;
			String DELIMITER = ",";
			String line;

			int i = 0;
			while ((line = br.readLine()) != null) {

				if (ignoreFirstLine) {
					ignoreFirstLine = false;
				} else {
					String[] columns = line.split(DELIMITER);
					Billete nuevo = new Billete(Integer.parseInt(columns[0]), // ID
							columns[1], // Nominacion
							Integer.parseInt(columns[2]) // Cantidad
					);

					listaBilletes[i] = nuevo;
					i++;
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public int getCantidad(String nominacion) {
		for (Billete b : listaBilletes) {
			if (b.getNominacion().equals(nominacion)) {
				return b.getCantidad();
			}
		}
		return 0;
	}

	public boolean entregarBilletes(float cantidad_retirar) {
		float restante = cantidad_retirar;

		int cantidad50000 = (int) Math.floor(restante / 50000);
		restante -= 50000 * cantidad50000;
		int cantidad20000 = (int) Math.floor(restante / 20000);
		restante -= 20000 * cantidad20000;
		int cantidad10000 = (int) Math.floor(restante / 10000);
		restante -= 10000 * cantidad10000;
		int cantidad5000 = (int) Math.floor(restante / 5000);
		restante -= 5000 * cantidad5000;
		int cantidad2000 = (int) Math.floor(restante / 2000);
		restante -= 2000 * cantidad2000;

		if (restante > 0 || restante < 0) {
			System.out.println("No hay billetes suficientes para la transacción requerida.");
			return false;
		} else {
			listaBilletes_bkp = new Billete[5];
			if (listaBilletes[0].getCantidad() - cantidad50000 >= 0) {
				listaBilletes_bkp[0] = listaBilletes[0];
				listaBilletes[0].disminuirCantidad(cantidad50000);
			} else {
				return false;
			}
			if (listaBilletes[1].getCantidad() - cantidad20000 >= 0) {
				listaBilletes_bkp[1] = listaBilletes[1];
				listaBilletes[1].disminuirCantidad(cantidad20000);
			} else {
				return false;
			}
			if (listaBilletes[2].getCantidad() - cantidad10000 >= 0) {
				listaBilletes_bkp[2] = listaBilletes[2];
				listaBilletes[2].disminuirCantidad(cantidad10000);
			} else {
				return false;
			}
			if (listaBilletes[3].getCantidad() - cantidad5000 >= 0) {
				listaBilletes_bkp[3] = listaBilletes[3];
				listaBilletes[3].disminuirCantidad(cantidad5000);
			} else {
				return false;
			}
			if (listaBilletes[4].getCantidad() - cantidad2000 >= 0) {
				listaBilletes_bkp[4] = listaBilletes[4];
				listaBilletes[4].disminuirCantidad(cantidad2000);
			} else {
				return false;
			}
		}

		return true;
	}

	public void restablecer() {
		if (listaBilletes_bkp != null) {
			for (int i = 0; i < 5; i++) {
				listaBilletes[i] = listaBilletes_bkp[i];
				listaBilletes_bkp[i] = null;
			}
		}

	}

}