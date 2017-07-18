package com.everis.alicante.courses.becajava.garage.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAO;

public class PlazaDAOFileImp implements PlazaDAO {

	@Override
	public Plaza[] readPlazas() throws IOException {
		List data=new ArrayList<String>();
		String linea;

		// buscar un fichero
		File file=new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		
		while((linea=buffer.readLine())!=null) {
			data.add(linea);
			System.out.println(linea);
		}
		
//		System.out.println(file.exists());
		
		
		return null;
	}

	@Override
	public void write(Plaza[] plazas) {
		
		
		
	}
	
	public static void main(String args[]) throws IOException {
		
		PlazaDAO dao = new PlazaDAOFileImp();
		dao.readPlazas();
		
	}

}
