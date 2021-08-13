package com.poker.backend.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poker.backend.rest.model.Jugador;
import com.poker.backend.rest.service.IPokerService;


@RestController
@RequestMapping
public class PokerController {
	
	@Autowired
	private IPokerService service;
	
	@GetMapping("/poker/{numJugadores}")
	public ResponseEntity<?> getGanador(@PathVariable Integer numJugadores){
		if(numJugadores > 1 && numJugadores <= 5) {
			List<Jugador> list = service.getGanador(numJugadores);
			return new ResponseEntity<List<Jugador>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("La condicion es que sean entre 1 y 5 jugadores.", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
