package com.everis.alicante.courses.beca.java_.garage;

import java.util.Scanner;

public class ControladorGarajeConArrays implements ControladorGaraje {

	@Override
	public Plaza[] listarPlazasLibres() {

		return null;
	}

	@Override
	public Plaza[] listarPlazasOcupadas() {

		return null;
	}

	@Override
	public boolean reservarPlaza() {
		// logica de si hay vacias
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();

		// vamos a escribir por pantalla un menu para meter los datos del cliente
		System.out.println("Introduce tu nombre completo: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce tu NIF: ");
		String nif = sc.nextLine();
		cliente.setNombreCompleto(nombre);
		cliente.setNif(nif);
		System.out.println("Tipo de vehiculo ");
		System.out.println("1 - Coche ");
		System.out.println("2 - Moto ");
		System.out.println("3 - Camion");

		int tipo = sc.nextInt();
		Vehiculo vehiculo = null;
		switch (tipo) {
		case 1:
			vehiculo = new Coche();

			break;
		case 2:
			vehiculo = new Motocicleta();

			break;
		case 3:
			vehiculo = new Camion();

			break;

		default:
			System.out.println("No ha seleccionado ninguno de los anteriores");
			break;
		}

		System.out.println("Inserte la Matricula del vehiculo");
		vehiculo.setMatricula(sc.nextLine());
		cliente.setVehiculo(vehiculo);

//		if (vehiculo instanceof Coche) {
//			System.out.println("Inserte la Marca");
//			((Coche) vehiculo).setMarca(sc.nextLine());
//		} else if (vehiculo instanceof Motocicleta) {
//			System.out.println("Inserte la Marca");
//			((Motocicleta) vehiculo).setMarca(sc.nextLine());
//		} else if (vehiculo instanceof Camion) {
//			((Camion) vehiculo).setMarca(sc.nextLine());
//		}

		
		boolean hayPlaza = false;
		Garaje garaje = GarajeMain.getGaraje();
		Plaza[] plazas = garaje.getPlazas();
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];

			if (plaza.getLibre() && vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayPlaza = true;
				return hayPlaza;
			}

		}
		return hayPlaza;

		// si hay plazas libres setteamos un cliente a la plaza que queramos

	}

}
