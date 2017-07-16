package com.everis.alicante.courses.beca.java_.garage;

public class Cliente {
	// vehiculo, dni, nombre
	private String nif;
	private String nombreCompleto;
	private Vehiculo vehiculo;

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Cliente = " + nombreCompleto + ", NIF = "+ nif + ", Vehiculo=" + vehiculo;
	}
	
}
