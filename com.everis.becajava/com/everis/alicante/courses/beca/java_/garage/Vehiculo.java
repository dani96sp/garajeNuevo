package com.everis.alicante.courses.beca.java_.garage;

public class Vehiculo {
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return getMatricula();
	}

}
