package com.everis.alicante.courses.becajava.garage.domain;

import java.util.List;

public class Garaje extends Plaza {
	// plaza[]
	//
	private List<Plaza> plazas;

	public List<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

}
