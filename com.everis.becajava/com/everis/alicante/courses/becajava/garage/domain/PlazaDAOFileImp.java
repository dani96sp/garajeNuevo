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
	public List<Plaza> readPlazas() throws IOException {
		
		List<Plaza> plazas = new ArrayList<Plaza>();
		String linea;

		// buscar un fichero
		File file=new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		
		while((linea=buffer.readLine())!=null) {
			if(!linea.contains("NUMERO_PLAZA")||linea.isEmpty()) {		
				Plaza plazaTemp = new Plaza();
			
				String[] tmp = linea.split(";");
				
				plazaTemp.setNumeroPlaza(Integer.parseInt(tmp[0]));
				
				plazaTemp.setPrecio(Double.parseDouble(tmp[1]));
				
				
				plazas.add(plazaTemp);
				
			}
		}
		
//		System.out.println(file.exists());
		
		
		return plazas;
	}

	@Override
	public void write(Plaza[] plazas) {
		
		
		
	}
	
	public static void main(String args[]) throws IOException {
		
		PlazaDAO dao = new PlazaDAOFileImp();
		dao.readPlazas();
		
	}

}
