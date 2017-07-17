package com.everis.alicante.courses.beca.java_.garage;

import java.util.Scanner;

public class GarajeMain {

	static Garaje garaje;

	static ControladorGaraje controlador;

	public static void main(String[] args) {
		inicializarComponentes(garaje);
		// Inicializacion de la aplicacion

		iniciarAplicacion();

	}

	public static void inicializarComponentes(Garaje garaje) {
		garaje = new Garaje();
		// 5 vehiculos
		Vehiculo[] vehiculos = new Vehiculo[5];

		for (int i = 0; i < 5; i++) {
			vehiculos[i] = new Vehiculo();

			vehiculos[i].setMatricula("MAT " + i + i + i + i);

			System.out.println(vehiculos[i].getMatricula());
		}
		vehiculos[3].setMatricula("BAT " + "3333");

		// 4 clientes
		Cliente[] clientes = new Cliente[20];

		for (int i = 0; i < 5; i++) {
			clientes[i] = new Cliente();

			clientes[i].setNif("" + i + i + i + i + i + i + i + i + "-L");

		}

		clientes[0].setNombreCompleto("Jose Martinez");
		clientes[0].setVehiculo(vehiculos[0]);
		System.out.println("NIF: " + clientes[0].getNif());
		System.out.println("Nombre: " + clientes[0].getNombreCompleto());
		System.out.println("Vehículo: " + clientes[0].getVehiculo());

		clientes[1].setNombreCompleto("Antonio Campello");
		clientes[1].setVehiculo(vehiculos[1]);
		System.out.println("NIF: " + clientes[1].getNif());
		System.out.println("Nombre: " + clientes[1].getNombreCompleto());
		System.out.println("Vehículo: " + clientes[1].getVehiculo());

		clientes[2].setNombreCompleto("Andrea Marin");
		clientes[2].setVehiculo(vehiculos[2]);
		System.out.println("NIF: " + clientes[2].getNif());
		System.out.println("Nombre: " + clientes[2].getNombreCompleto());
		System.out.println("Vehículo: " + clientes[2].getVehiculo());

		clientes[3].setNombreCompleto("Bruce Wayne");
		clientes[3].setVehiculo(vehiculos[3]);
		System.out.println("NIF: " + clientes[3].getNif());
		System.out.println("Nombre: " + clientes[3].getNombreCompleto());
		System.out.println("Vehículo: " + clientes[3].getVehiculo());

		clientes[4].setNombreCompleto("Peter Parker");
		clientes[4].setVehiculo(vehiculos[4]);
		System.out.println("NIF: " + clientes[4].getNif());
		System.out.println("Nombre: " + clientes[4].getNombreCompleto());
		System.out.println("Vehículo: " + clientes[4].getVehiculo());

		// 30 plazas de garaje


		Plaza[] plazas = new Plaza[30];

		for (int i = 0; i < 30; i++) {
			Plaza plazaTemp = new Plaza();
			plazaTemp.setNumeroPlaza(i + 1);

			plazas[i] = plazaTemp;

			if (i < 10) {
				plazas[i].setPrecio(50);
			} else if (i < 20) {
				plazas[i].setPrecio(75);
			} else {
				plazas[i].setPrecio(100);
			}

			plazas[i].setCliente(null);
		}

		for (int i = 0; i < 4; i++) {
			int p = i + 1;
			plazas[i].setCliente(clientes[i]);
			System.out.println("Plaza " + p + ": " + plazas[i].getCliente());
		}

		// 1 garaje
		garaje.setPlazas(plazas);
		System.out.println(garaje);

		controlador = new ControladorGarajeConArrays();

	}

	private static void iniciarAplicacion() {
		Scanner sc = new Scanner(System.in);

		System.out.println("");
		System.out.println("");
		System.out.println("**************************************************************");
		System.out.println("Bienvenido al garaje");
		System.out.println("1 - Plazas Disponibles");
		System.out.println("2- Plazas Ocupadas");
		System.out.println("3 - Reservar una Plaza");
		System.out.println("4 - Listar Clientes");
		System.out.println("5 - Listar Vehiculos");
		System.out.println("*6 - Ver Ingreso Mensual");

		// System.out.println("");
		// System.out.println("1 - Listar Plazas");

		int option = sc.nextInt();
		boolean resultado = true;
		

		
		System.out.println("Ha elegido la opcion :" + option);
		switch (option) {
		case 1:
			controlador.listarPlazasLibres();
			break;
		case 2:
			controlador.listarPlazasOcupadas();
			break;
		case 3:
			resultado = controlador.reservarPlaza();
			break;
		case 4:
			System.out.println("Opcion sin implementar.");
			break;
		case 5:
			System.out.println("Opcion sin implementar.");
			break;
		case 6:
			System.out.println("Opcion sin implementar.");
			break;

		default:
			break;
		}
		
		if (option == 3 && resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if (option == 3) {
			System.out.println("No hay plaza disponible");
		}
		
		iniciarAplicacion();

	}

	public static Garaje getGaraje() {
		return garaje;
	}

}
