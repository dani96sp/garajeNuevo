package com.everis.alicante.courses.beca.java_.garage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControladorGarajeConArrays implements ControladorGaraje {

	@Override
	public void listarPlazasLibres() {

		List<Plaza> plazaslibres = new ArrayList<Plaza>();

		Plaza[] plazas = GarajeMain.getGaraje().getPlazas();

		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];

			if (plaza.getLibre()) {

				plazaslibres.add(plaza);

			}

		}

		// listar por pantalla
		for (Plaza plaza : plazaslibres) {
			System.out.println(plaza);
		}

	}

	@Override
	public void listarPlazasOcupadas() {
		List<Plaza> plazasocupadas = new ArrayList<Plaza>();

		Plaza[] plazas = GarajeMain.getGaraje().getPlazas();

		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];

			if (!plaza.getLibre()) {

				plazasocupadas.add(plaza);

			}

		}

		// listar por pantalla
		for (Plaza plaza : plazasocupadas) {
			System.out.println(plaza);
		}
	}

	@Override
	public boolean reservarPlaza() {
		// logica de crear cliente
		Cliente cliente = new Cliente();

		// vamos a escribir por pantalla un menu para meter los datos del cliente
		System.out.println("Introduce tu nombre completo: ");
		
		Scanner sc = new Scanner(System.in);
		cliente.setNombreCompleto(sc.nextLine());
		
		System.out.println("Introduce tu NIF: ");	
		sc = new Scanner(System.in);
		cliente.setNif(sc.nextLine());
		
		Vehiculo vehiculo = null;

		System.out.println("Tipo de vehiculo ");
		System.out.println("1 - Coche ");
		System.out.println("2 - Moto ");
		System.out.println("3 - Camion");
		
		sc = new Scanner(System.in);
		switch (sc.nextInt()) {
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
				break;
		}

		System.out.println("Inserte la Matricula del vehiculo");
		sc = new Scanner(System.in);
		vehiculo.setMatricula(sc.nextLine());
		cliente.setVehiculo(vehiculo);

		boolean hayplaza = false;
		Garaje garaje = GarajeMain.getGaraje();
		Plaza[] plazas = garaje.getPlazas();
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];

			if (plaza.getLibre() && vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;
				return hayplaza;
			}

		}
		return hayplaza;

		// si hay plazas libres setteamos un cliente a la plaza que queramos

	}

}
