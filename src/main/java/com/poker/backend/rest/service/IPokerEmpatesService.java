package com.poker.backend.rest.service;

import java.util.List;

import com.poker.backend.rest.model.Jugador;

public interface IPokerEmpatesService {

	public void desempateRoyalFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateStraightFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateFourOfAKind(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateFullHouse(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateStraight(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateThreeOfAKind(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateTwoPair(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public Integer desempateOnePair(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
	public void desempateHighCard(Integer win, Integer cantJugadores, List<Jugador> listaJugadores);
}
