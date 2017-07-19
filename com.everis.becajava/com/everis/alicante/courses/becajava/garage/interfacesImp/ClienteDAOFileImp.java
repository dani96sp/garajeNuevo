package com.everis.alicante.courses.becajava.garage.interfacesImp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.GarajeMain;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.ClienteDAO;

public class ClienteDAOFileImp implements ClienteDAO {

	@Override
	public 	Map<String, Cliente> readClientes() throws FileNotFoundException, IOException {

		Map clientes = new HashMap<>();
		
		String linea;

		// buscar un fichero
		File file = new File("src/resources/Clientes.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {
			if (!linea.contains("NUMERO_PLAZA") || linea.isEmpty()) {
				Map cliente = new HashMap<>();

				String[] tmp = linea.split(";");
//				tmp[0]
				cliente.setNif(tmp[0]);
				
				
				Vehiculo vehiculo = GarajeMain.getGaraje().getCliente().getVehiculo();

//				Map vehiculo = new HashMap<>();

//				vehiculo.put("2123223", new Vehiculo());
				
//				cliente.setVehiculo(vehiculo).setMatricula(tmp[1]);
				cliente.setVehiculo(GarajeMain.getGaraje().getCliente(vehiculo).setMatricula(tmp[1]);

				cliente.setNif(tmp[2]);

				clientes.add(cliente);

			}
		}
		buffer.close();
		return clientes;
	}

	@Override
	public void createCliente(Cliente cliente) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
