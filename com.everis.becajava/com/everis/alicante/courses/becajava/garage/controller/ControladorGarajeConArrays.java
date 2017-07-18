package com.everis.alicante.courses.becajava.garage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.GarajeMain;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Motocicleta;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.ReservaDAOFileImp;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGaraje;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;

public class ControladorGarajeConArrays implements ControladorGaraje {

	@Override
	public void listarPlazasLibres() {

		List<Plaza> plazaslibres = new ArrayList<Plaza>();

		List<Plaza> plazas = GarajeMain.getGaraje().getPlazas();
		
		for (Plaza plaza : plazas) {
			
		}
		
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);

			if (plaza.getLibre()) {

				plazaslibres.add(plaza);

			}

		}

		// listar por pantalla
		for (Plaza plaza1 : plazaslibres) {
			System.out.println(plaza1);
		}

	}

	@Override
	public void listarPlazasOcupadas() {
		List<Plaza> plazasocupadas = new ArrayList<Plaza>();

		List<Plaza> plazas = GarajeMain.getGaraje().getPlazas();

		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);

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
	public boolean reservarPlaza() throws IOException {
		// logica de crear cliente
		Cliente cliente = new Cliente();
		
		ReservaDAO dao = new ReservaDAOFileImp();
		
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
		List<Plaza> plazas = garaje.getPlazas();
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);

			if (plaza.getLibre() && vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;
				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				
				dao.saveReserva(reserva);
				
				return hayplaza;
				
			}

		}
		return hayplaza;

		// si hay plazas libres setteamos un cliente a la plaza que queramos

	}

}
