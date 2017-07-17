package com.everis.alicante.courses.beca.java_.garage;

public class Plaza {
	// cliente, precio
	private double precio;
	private Cliente cliente;
	private int numeroPlaza;

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
		return "Plaza [" + numeroPlaza + "precio=" + precio + ", cliente=" + cliente + "]";
	}

}
