package com.everis.alicante.courses.becajava.garage.domain;

public class Plaza {

	private double precio;

	private Cliente cliente;

	private int numeroPlaza;

	public Boolean getLibre() {
		if (cliente == null) {
			return true;
		} else {
			return false;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumeroPlaza() {
		return numeroPlaza;
	}

	public void setNumeroPlaza(int numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}

	@Override
	public String toString() {
		return "Plaza: " + numeroPlaza + " - Precio=" + precio + ", Cliente=" + cliente;
	}

}
