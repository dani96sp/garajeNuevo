package com.everis.alicante.courses.becajava.garage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGaraje;
import com.everis.alicante.courses.becajava.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.interfacesImp.ClienteDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfacesImp.PlazaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.interfacesImp.ReservaDAOFileImp;

public class GarajeMain {

	static Garaje garaje;

	static ControladorGaraje controlador;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		inicializarComponentes();
		// Inicializacion de la aplicacion

		iniciarAplicacion();

	}


	private static void iniciarAplicacion() throws IOException {
		System.out.println("**************************************************************");
		System.out.println("1 - Plazas Disponibles");
		System.out.println("2- Plazas Ocupadas");
		System.out.println("3 - Reservar una Plaza");
		System.out.println("4 - Listar Clientes");
		System.out.println("5 - Listar Vehiculos");
		System.out.println("*6 - Ver Ingreso Mensual");
		System.out.println("0 - Salir de la aplicacion");
		
		Scanner sc = new Scanner(System.in);

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
			controlador.listarClientes();	
			break;
		case 5:
			System.out.println("Opcion sin implementar.");
			break;
		case 6:
			System.out.println("Opcion sin implementar.");
			break;
		case 0:
			System.out.println("Saliendo de la aplicacion.");
			break;

		default:
			break;
		}

		if (option == 3 && resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if (option == 3) {
			System.out.println("No hay plaza disponible");
		}
		if (option != 0) {
			iniciarAplicacion();
		}

	}
	public static void inicializarComponentes() throws FileNotFoundException, IOException {

		garaje = new Garaje();

		PlazaDAO plazaDao = new PlazaDAOFileImp();
		ReservaDAO reservaDao = new ReservaDAOFileImp();
		ClienteDAO clienteDao = new ClienteDAOFileImp();
		
		garaje.setPlazas(plazaDao.readPlazas());

//		List<Plaza> plazasTemp = plazaDao.readPlazas();

//		garaje.setPlazas(plazasTemp);
		garaje.setClientes(clienteDao.readClientes());

		controlador = new ControladorGarajeConArrays();

	}
	
	
	public static Garaje getGaraje() {
		return garaje;
	}

}
