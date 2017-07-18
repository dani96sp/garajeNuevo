package com.everis.alicante.courses.becajava.garage.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void saveReserva(Reserva reserva) throws IOException {
		
		File file=new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter buffer = new BufferedWriter(writer);

		buffer.newLine();
		buffer.write(reserva.toTxtFile());
		buffer.close();
		
	}

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
		
		dao.saveReserva(reserva);
		
	}
	
	
	
}
