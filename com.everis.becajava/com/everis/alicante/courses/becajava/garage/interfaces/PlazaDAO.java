package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;

public interface PlazaDAO {
	
	Plaza[] readPlazas() throws FileNotFoundException, IOException;
	
	void write(Plaza[] plazas);
	
}
