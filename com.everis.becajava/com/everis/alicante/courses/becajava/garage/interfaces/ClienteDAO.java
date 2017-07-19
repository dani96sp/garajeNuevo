package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;

public interface ClienteDAO {
	Map<String, Cliente> readClientes() throws FileNotFoundException, IOException;

	void createCliente(Cliente cliente) throws IOException;
	
}