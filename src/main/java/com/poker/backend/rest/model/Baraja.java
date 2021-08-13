package com.poker.backend.rest.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Baraja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*
	 * Valores 
	 * s: Picas
	 * h: Corazones
	 * c: Treboles
	 * d: Diamantes
	 */
	private List<String> tipoCarta = Arrays.asList("s","h","c","d");
	private List<String> valorCarta = Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K");
	
	public List<String> getTipoCarta() {
		return tipoCarta;
	}
	public void setTipoCarta(List<String> tipoCarta) {
		this.tipoCarta = tipoCarta;
	}
	public List<String> getValorCarta() {
		return valorCarta;
	}
	public void setValorCarta(List<String> valorCarta) {
		this.valorCarta = valorCarta;
	}
	
	
}
