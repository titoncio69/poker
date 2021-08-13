package com.poker.backend.rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.backend.rest.model.Baraja;
import com.poker.backend.rest.model.Jugador;
import com.poker.backend.rest.service.IManosPokerService;
import com.poker.backend.rest.service.IPokerEmpatesService;
import com.poker.backend.rest.service.IPokerService;
import com.poker.backend.rest.utils.Prueba;

@Service
public class PokerServiceImpl implements IPokerService {

	@Autowired
	private IManosPokerService manos;
	
	@Autowired
	private IPokerEmpatesService empate;

	private static final Logger log = Logger.getLogger(PokerServiceImpl.class);
	private static List<Jugador> listaJugadores = new ArrayList<Jugador>();
	private Baraja baraja = new Baraja();
	private static final Integer CARTAS_MANO = 5;

	@Override
	public List<Jugador> getGanador(Integer numJugadores) {
		listaJugadores.clear();
		// se les asigna una mano de 5 cartas a cada jugador
		manoJugadores(numJugadores);

		// Evaluar que juego tiene cada mano
		evaluarCadaMano();
		
		comprobarGanadorAndEmpates();

		return listaJugadores;
	}
	
	private void comprobarGanadorAndEmpates() {
		//crear lista de resultados
		List<Integer> listaResultados = new ArrayList<Integer>();
		//llenar lista con los resultados que tuvo cada uno
		listaJugadores.forEach(j -> listaResultados.add(j.getValorResultado()));
		log.info(listaResultados.toString());
		Integer win = listaResultados.stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);
		log.info("win: " + win);
		Integer cantGanadores = Collections.frequency(listaResultados, win);
		log.info("cantGanadores: " + cantGanadores);
		if(cantGanadores == 1) {
			for (Jugador jugador : listaJugadores) {
				if(jugador.getValorResultado() == win) {
					jugador.setGanador(true);
				}else {
					jugador.setGanador(false);
				}
			}
		}else {
			//Se busca con que resultado se empato para establecer un ganador
			switch (win) {
//			case 1:
//				empate.desempateRoyalFlush(win, cantGanadores, listaJugadores);
//				break;
			case 2:
				empate.desempateStraightFlush(win, cantGanadores, listaJugadores);
				break;
			case 3:
				empate.desempateFourOfAKind(win, cantGanadores, listaJugadores);
				break;
			case 4:
				empate.desempateFullHouse(win, cantGanadores, listaJugadores);
				break;
			case 5:
				empate.desempateFlush(win, cantGanadores, listaJugadores);
				break;
			case 6:
				empate.desempateStraight(win, cantGanadores, listaJugadores);
				break;
			case 7:
				empate.desempateThreeOfAKind(win, cantGanadores, listaJugadores);
				break;
			case 8:
				empate.desempateTwoPair(win, cantGanadores, listaJugadores);
				break;
			case 9:
				Integer ganador = empate.desempateOnePair(win, cantGanadores, listaJugadores);
				listaJugadores.forEach(j -> {
					if(j.getNumeroJugador() == ganador) {
						j.setGanador(true);
					}else {
						j.setGanador(false);
					}
				});
				break;
			case 10:
				empate.desempateHighCard(win, cantGanadores, listaJugadores);
				break;
			default:
				break;
			}
		}
		
	}

	private void manoJugadores(Integer numJugadores) {
		// crear lista de jugadores
		for (int i = 0; i < numJugadores; i++) {
			Jugador jugador = new Jugador();
			//se le asigna mano a cada jugador
			jugador = asignarManoJugador(jugador);
			jugador.setNumeroJugador(i+1);
			listaJugadores.add(jugador);
		}
//		Se uso de prueba
//		Prueba p = new Prueba();
//		listaJugadores.addAll(p.crearjugador());
	}

	private Jugador asignarManoJugador(Jugador jugador) {
		Random rand = new Random();
		String[] cartas = new String[CARTAS_MANO];
		for (int i = 0; i < CARTAS_MANO; i++) {
			String carta = null;
			// Se incluye DO-WHILE ya que no puede repetirse el par tipo-valor.
			do {
				int posicionTipo = rand.nextInt(baraja.getTipoCarta().size());
				String tipo = baraja.getTipoCarta().get(posicionTipo);
				int posicionValor = rand.nextInt(baraja.getValorCarta().size());
				String valor = baraja.getValorCarta().get(posicionValor);
				carta = tipo + "-" + valor;
				boolean bol = cartaRepartida(carta);
				// las que salen en true ya estan repartidas por ende no se puede repartir 2
				// veces
				log.info(bol + " | " + carta);
			} while (Arrays.stream(cartas).anyMatch(carta::equals) || cartaRepartida(carta));
			{
				cartas[i] = carta;
			}
		}
		jugador.setMano(cartas);
		return jugador;
	}

	private boolean cartaRepartida(String carta) {
		boolean b = false;
		if (listaJugadores.size() > 0) {
			for (Jugador j : listaJugadores) {
				b = (Arrays.stream(j.getMano()).anyMatch(carta::equals)) ? true : false;
			}
		}
		return b;
	}

	private void evaluarCadaMano() {
		for (Jugador jugador : listaJugadores) {
			String result = "";
			int resultValue;
			if (manos.royalFlush(jugador.getMano())) {
				result = "Royal Flush";
				resultValue = 1;
			} else if (manos.straightFlush(jugador.getMano())) {
				result = "Straight Flush";
				resultValue = 2;
			} else if (manos.fourOfAKind(jugador.getMano())) {
				result = "Four of a Kind";
				resultValue = 3;
			} else if (manos.fullHouse(jugador.getMano())) {
				result = "Full House";
				resultValue = 4;
			} else if (manos.flush(jugador.getMano())) {
				result = "Flush";
				resultValue = 5;
			} else if (manos.Straight(jugador.getMano())) {
				result = "Straight";
				resultValue = 6;
			} else if (manos.threeOfAKind(jugador.getMano())) {
				result = "Three of a Kind";
				resultValue = 7;
			} else if (manos.twoPair(jugador.getMano())) {
				result = "Two Pair";
				resultValue = 8;
			} else if (manos.onePair(jugador.getMano())) {
				result = "One Pair";
				resultValue = 9;
			} else {
				result = manos.highCard(jugador.getMano());
				resultValue = 10;
			}
			jugador.setResultado(result);
			jugador.setValorResultado(resultValue);
		}
	}
}
