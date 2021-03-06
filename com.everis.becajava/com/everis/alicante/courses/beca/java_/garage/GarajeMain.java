package com.everis.alicante.courses.beca.java_.garage;

public class GarajeMain {

	public static void main(String[] args) {
		// Inicializacion de la aplicacion

		// 5 vehiculos
		Vehiculo[] vehiculos = new Vehiculo[5];

		for (int i = 0; i < 5; i++) {
			vehiculos[i] = new Vehiculo();

			vehiculos[i].setMatricula("MAT " + i + i + i + i);

			System.out.println(vehiculos[i].getMatricula());
		}
		vehiculos[3].setMatricula("BAT " + "3333");

		// 4 clientes
		Cliente[] clientes = new Cliente[4];

		for (int i = 0; i < 4; i++) {
			clientes[i] = new Cliente();

			clientes[i].setNif("" + i + i + i + i + i + i + i + i + "-L");

		}

		clientes[0].setNombreCompleto("Jose Martinez");
		clientes[0].setVehiculo(vehiculos[0]);
		System.out.println("NIF: " + clientes[0].getNif());
		System.out.println("Nombre: " + clientes[0].getNombreCompleto());
		System.out.println("Veh�culo: " + clientes[0].getVehiculo());

		clientes[1].setNombreCompleto("Antonio Campello");
		clientes[1].setVehiculo(vehiculos[1]);
		System.out.println("NIF: " + clientes[1].getNif());
		System.out.println("Nombre: " + clientes[1].getNombreCompleto());
		System.out.println("Veh�culo: " + clientes[1].getVehiculo());

		clientes[2].setNombreCompleto("Andrea Marin");
		clientes[2].setVehiculo(vehiculos[2]);
		System.out.println("NIF: " + clientes[2].getNif());
		System.out.println("Nombre: " + clientes[2].getNombreCompleto());
		System.out.println("Veh�culo: " + clientes[2].getVehiculo());

		clientes[3].setNombreCompleto("Bruce Wayne");
		clientes[3].setVehiculo(vehiculos[3]);
		System.out.println("NIF: " + clientes[3].getNif());
		System.out.println("Nombre: " + clientes[3].getNombreCompleto());
		System.out.println("Veh�culo: " + clientes[3].getVehiculo());

		// 30 plazas de garaje
		Plaza[] plazas = new Plaza[30];

		for (int i = 0; i < 30; i++) {
			plazas[i] = new Plaza();

			plazas[i].setPrecio(1000 + i);

			plazas[i].setCliente(null);
		}

		for (int i = 0; i < 4; i++) {
			int p = i + 1;
			plazas[i].setCliente(clientes[i]);
			System.out.println("Plaza " + p + ": " + plazas[i].getCliente());
		}

		// 1 garaje
		Garaje garaje = new Garaje();
		garaje.setPlazas(new Plaza[30]);

		System.out.println(garaje);

		inicializarComponentes();
	}

	public static void inicializarComponentes() {

	}
}
