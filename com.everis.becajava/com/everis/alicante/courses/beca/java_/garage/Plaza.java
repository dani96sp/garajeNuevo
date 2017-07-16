package com.everis.alicante.courses.beca.java_.garage;

public class Plaza {
	// cliente, precio
	private double precio;
	private Cliente cliente;

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

	@Override
	public String toString() {
		return "Plaza [precio=" + precio + ", cliente=" + cliente + "]";
	}

}
