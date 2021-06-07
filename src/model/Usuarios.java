package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Usuarios {
	private ArrayList<Usuario> listaUsuarios;

	public Usuarios() {
		listaUsuarios = new ArrayList<Usuario>();

		try (BufferedReader br = Files
				.newBufferedReader(Paths.get("data\\usuarios.csv").toAbsolutePath())) {

			boolean ignoreFirstLine = true;
			String DELIMITER = ",";
			String line;

			while ((line = br.readLine()) != null) {

				if (ignoreFirstLine) {
					ignoreFirstLine = false;
				} else {
					String[] columns = line.split(DELIMITER);
					Usuario nuevo = new Usuario(Integer.parseInt(columns[0]), // ID
							columns[1], // Nombres
							columns[2], // Apellidos
							columns[3], // Contrasena
							Float.parseFloat(columns[4]) // Saldo Actual
					);

					listaUsuarios.add(nuevo);

				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public boolean compararUsuario(Usuario a) {
		for (Usuario b : listaUsuarios) {
			if (a.getNombres().equals(b.getNombres()) && a.getApellidos().equals(b.getApellidos())
					&& a.getContrasena().equals(b.getContrasena())) {
				return true;
			}
		}
		return false;
	}

	public boolean compararUsuarioPorID(Usuario a) {
		for (Usuario b : listaUsuarios) {
			if (a.getID() == b.getID() && a.getContrasena().equals(b.getContrasena())) {
				return true;
			}
		}
		return false;
	}

	public Usuario getUsuario(Usuario a) {
		for (Usuario b : listaUsuarios) {
			if (a.getID() == b.getID() && a.getContrasena().equals(b.getContrasena())) {
				return b;
			}
		}
		return null;
	}

}
