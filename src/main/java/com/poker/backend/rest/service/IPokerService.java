package com.poker.backend.rest.service;

import java.util.List;

import com.poker.backend.rest.model.Jugador;

public interface IPokerService {
	
	public List<Jugador> getGanador(Integer numJugadores);
}
