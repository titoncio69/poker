package com.poker.backend.rest.model;

import java.io.Serializable;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mano[] = new String[5];
	private String resultado;
	private Integer valorResultado;
	private Boolean ganador;
	private Integer numeroJugador;

	public Integer getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(Integer numeroJugador) {
		this.numeroJugador = numeroJugador;
	}

	public Boolean getGanador() {
		return ganador;
	}

	public void setGanador(Boolean ganador) {
		this.ganador = ganador;
	}

	public Integer getValorResultado() {
		return valorResultado;
	}

	public void setValorResultado(Integer valorResultado) {
		this.valorResultado = valorResultado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String[] getMano() {
		return mano;
	}

	public void setMano(String[] mano) {
		this.mano = mano;
	}

}
