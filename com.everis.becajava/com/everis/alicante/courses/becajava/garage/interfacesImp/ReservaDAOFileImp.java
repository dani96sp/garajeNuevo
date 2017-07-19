package com.everis.alicante.courses.becajava.garage.interfacesImp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.GarajeMain;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	public static void main(String args[]) throws IOException {

		Reserva reserva = new Reserva();

		Cliente cliente = new Cliente();
		cliente.setNif("nif123");

		Plaza plaza = new Plaza();
		plaza.setNumeroPlaza(1);

		Vehiculo vehiculo = new Vehiculo();

		cliente.setVehiculo(vehiculo);
		reserva.setCliente(cliente);
		reserva.setPlaza(plaza);
		reserva.setFechaReserva(Calendar.getInstance().getTime());

		ReservaDAO dao = new ReservaDAOFileImp();

		dao.createReserva(reserva);

	}
	
	@Override
	public void createReserva(Reserva reserva) throws IOException {

		File file = new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);

		buffer.newLine();
		buffer.write(reserva.toTxtFile());
		buffer.close();

	}

	@Override
	public Map<String, Reserva> readReservas() throws IOException {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		String linea;

		// buscar un fichero
		File file = new File("src/resources/Reservas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {
			if (!linea.contains("NUMERO_PLAZA") || linea.isEmpty()) {
				Reserva reserva = new Reserva();
// CODIGO_RESERVA;NUMERO_PLAZA;NIF;MATRICULA;FECHA_RESERVA
				String[] tmp = linea.split(";");

				reserva.setCodigoReserva(tmp[0]);

				Plaza plaza = GarajeMain.getGaraje().getPlazas().get(Integer.parseInt((tmp[1])));

				reserva.setPlaza(plaza);							

				reservas.add(reserva);

			}
		}
		buffer.close();
		return reservas;
	}


}
