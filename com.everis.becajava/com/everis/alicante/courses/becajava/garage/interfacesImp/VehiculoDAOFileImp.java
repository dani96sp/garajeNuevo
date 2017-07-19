package com.everis.alicante.courses.becajava.garage.interfacesImp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.VehiculoDAO;

public class VehiculoDAOFileImp implements VehiculoDAO{

	@Override
	public Map<String, Vehiculo> readVehiculos() throws FileNotFoundException, IOException {

		Map vehiculos = new HashMap<>();
		
		
		String linea;

		// buscar un fichero
		File file = new File("src/resources/Vehiculos.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		while ((linea = buffer.readLine()) != null) {
			if (!linea.contains("NUMERO_PLAZA") || linea.isEmpty()) {
				Vehiculo vehiculo = new Vehiculo();
				
				String[] tmp = linea.split(";");
				
				vehiculo.setMatricula(tmp[0]);

				

				vehiculos.add(vehiculo);

			}
		}
		buffer.close();
		return vehiculos;
	}

	@Override
	public void createVehiculo(Vehiculo vehiculo) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
