package controller;

import model.Usuarios;
import model.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Billetes;
import view.Principal;
import view.ConsultarSaldo;
import view.RetirarSaldo;
import view.Contenedor;
import view.MontoRetirar;
import view.Autenticacion;

public class Main {

	Usuarios usuarios;
	Billetes bill;

	Contenedor contenedor = new Contenedor();
	Principal p;
	Autenticacion a;
	RetirarSaldo r;
	ConsultarSaldo c;
	MontoRetirar m;

	float saldo_retirar;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		usuarios = new Usuarios();
		bill = new Billetes();

		initialize();

		contenedor.setVisible(true);
		contenedor.changeWindow(p);
	}

	private void initialize() {
		p = new Principal();
		a = new Autenticacion();
		r = new RetirarSaldo();
		c = new ConsultarSaldo();
		m = new MontoRetirar();

		p.addActionListener(p.getBtnConsultarSaldo(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setConsultarSaldoWindow();
				autenticar(c, "consultar_saldo");
			}
		});

		p.addActionListener(p.getBtnRetirar(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMontoRetirar();
			}
		});
	}

	private void autenticar(JPanel p, String accion) {
		a.setTxtContrasena("");
		a.setTxtUsuario("");
		a.addActionListener(a.getBtnContinuar(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario tmp = new Usuario(Integer.parseInt(a.getUsuario()), a.getContrasena());
				if (usuarios.compararUsuarioPorID(tmp)) {

					if (accion == "consultar_saldo") {
						setConsultarSaldo(tmp);
					} else if (accion == "retirar_saldo") {
						setRetirarSaldo(tmp);
					}

					contenedor.changeWindow(p);
				} else {
					a.setMostrar("Usuario o Contraseña Incorrectos");
				}
			}
		});
		contenedor.changeWindow(a);
	}

	private void setConsultarSaldoWindow() {
		this.c.addActionListener(c.getBtnRetirar(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMontoRetirar();
			}
		});

		this.c.addActionListener(c.getBtnSalir(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
				contenedor.changeWindow(p);
			}
		});

		contenedor.changeWindow(c);
	}

	private void setConsultarSaldo(Usuario tmp) {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Usuario: ");
		sb.append(usuarios.getUsuario(tmp).getNombres());
		sb.append(" ");
		sb.append(usuarios.getUsuario(tmp).getApellidos());
		sb.append("\n");
		sb.append("Saldo actual: ");
		sb.append(usuarios.getUsuario(tmp).getSaldo());

		this.c.setMostrar(sb.toString());
	}

	private void setMontoRetirar() {
		this.m.addActionListener(m.getBtnContinuar(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saldo_retirar = Float.parseFloat(m.getTxtMontoRetirar());
					autenticar(r, "retirar_saldo");
				} catch (Exception ex) {
					m.setMostrar("El monto suministrado no es un valor valido.");
				}
			}
		});

		contenedor.changeWindow(m);
	}

	private void setRetirarSaldo(Usuario tmp) {

		r.setMostrar("Procesando...");
		if (usuarios.getUsuario(tmp).restarSaldo(saldo_retirar) && bill.entregarBilletes(saldo_retirar)) {
			usuarios.getUsuario(tmp).setUsuario(usuarios.getUsuario(tmp));
			StringBuilder sb = new StringBuilder("\n");
			sb.append("Usuario: ");
			sb.append(usuarios.getUsuario(tmp).getNombres());
			sb.append(" ");
			sb.append(usuarios.getUsuario(tmp).getApellidos());
			sb.append("\n");
			sb.append("Saldo actual: ");
			sb.append(usuarios.getUsuario(tmp).getSaldo());

			this.r.setMostrar(sb.toString());

		} else {
			usuarios.getUsuario(tmp).restablecer();
			bill.restablecer();
			r.setMostrar("No se puede retirar esa cantidad de dinero.");
		}

		r.addActionListener(r.getBtnSalir(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize();
				contenedor.changeWindow(p);
			}
		});
	}
}
