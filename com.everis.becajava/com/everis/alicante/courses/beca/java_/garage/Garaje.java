package com.everis.alicante.courses.beca.java_.garage;

public class Garaje extends Plaza {
	// plaza[]
	//
	private Plaza[] plazas;

	public Plaza[] getPlazas() {
		return plazas;
	}

	public void setPlazas(Plaza[] plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "Garaje [plazas=" + plazas.length + "]";
	}

}
