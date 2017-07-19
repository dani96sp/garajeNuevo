package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public interface VehiculoDAO {
	
	 Map<String, Vehiculo> readVehiculos() throws FileNotFoundException, IOException;

	void createVehiculo(Vehiculo vehiculo) throws IOException;

}
