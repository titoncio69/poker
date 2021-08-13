package com.poker.backend.rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.util.PropertySource.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.backend.rest.model.Jugador;
import com.poker.backend.rest.service.IPokerEmpatesService;
import com.poker.backend.rest.utils.MetodosUtiles;

@Service
public class PokerEmpatesServiceImpl implements IPokerEmpatesService{
	
	@Autowired
	private MetodosUtiles util;
	
	private static final Logger log = Logger.getLogger(PokerEmpatesServiceImpl.class);
	
	@Override
	public void desempateRoyalFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
	}

	@Override
	public void desempateStraightFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		
	}

	@Override
	public void desempateFourOfAKind(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desempateFullHouse(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desempateFlush(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desempateStraight(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desempateThreeOfAKind(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desempateTwoPair(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer desempateOnePair(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		List<Jugador> ganadores = new ArrayList<Jugador>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		listaJugadores.forEach(l -> {
			if(l.getValorResultado() == win) {
				ganadores.add(l);
			}else {
				l.setGanador(false);
			}
		});
		ganadores.forEach(g -> {
			List<Integer> list = util.arrayStringToListNumberSort(g.getMano());
			map2.put(g.getNumeroJugador(), list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toList()).get(0));
		});
		
		Integer maxValue = map2.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
		Integer maxKey = map2.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		log.info(map2);
		int ocurrencias = Collections.frequency(map2.values(), maxValue);
		if(ocurrencias == 1) {
			return maxKey;
		}else {
			map2.entrySet().removeIf(n -> n.getValue() != maxValue);
			util.desempate(map2, listaJugadores, maxValue);
		}
		
		
		log.info(map2);
		log.info(maxKey + "-" + maxValue);
		log.info("ocurrencias: " + ocurrencias);
		return null;
	}
	
	@Override
	public void desempateHighCard(Integer win, Integer cantJugadores, List<Jugador> listaJugadores) {
		// TODO Auto-generated method stub
	}
}
