package com.everis.alicante.courses.beca.java_.garage;

public class Motocicleta extends Vehiculo implements Aparcable {
	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void aparcar() {
		System.out.println("Puedo aparcar");
	}

}
