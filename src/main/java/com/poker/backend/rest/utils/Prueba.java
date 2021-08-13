package com.poker.backend.rest.utils;

import java.util.ArrayList;
import java.util.List;

import com.poker.backend.rest.model.Jugador;

public class Prueba {

	public List<Jugador> crearjugador() {
		List<Jugador> lista = new ArrayList<Jugador>();
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		Jugador j3 = new Jugador();
		Jugador j4 = new Jugador();
		Jugador j5 = new Jugador();
		
		String[] mano1 = {"c-2","h-J","h-A","s-J","h-5"};
		String[] mano2 = {"c-2","h-Q","h-4","s-K","h-5"};
		String[] mano3 = {"c-2","h-Q","h-4","s-K","h-5"};
		String[] mano4 = {"c-5","h-Q","h-4","s-K","h-5"};
		String[] mano5 = {"d-3","s-Q","d-J","d-4","c-J"};
		
		//crear jugadores para test
		//jugador1
		j1.setNumeroJugador(1);
		j1.setMano(mano1);
		
		//jugador2
		j2.setNumeroJugador(2);
		j2.setMano(mano2);
		
		//jugador1
		j3.setNumeroJugador(3);
		j3.setMano(mano3);
		
		//jugador1
		j4.setNumeroJugador(4);
		j4.setMano(mano4);
		
		//jugador1
		j5.setNumeroJugador(5);
		j5.setMano(mano5);
		
		lista.add(j1);
		lista.add(j2);
		lista.add(j3);
		lista.add(j4);
		lista.add(j5);
		
		return lista;
	}
}
