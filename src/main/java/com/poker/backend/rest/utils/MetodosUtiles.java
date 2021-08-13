package com.poker.backend.rest.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.poker.backend.rest.model.Jugador;

@Component
public class MetodosUtiles {

	private static final Logger log = Logger.getLogger(MetodosUtiles.class);
//	private static String[] manoPrueba = { "s-4", "h-A", "c-2", "d-2", "h-10" };

	public boolean encontrarCartasMismaPinta(String[] mano) {
		boolean b;
		int contador = 0;
		String carta = mano[0];
		String pinta = carta.split("-")[0];
		for (int i = 0; i < mano.length; i++) {
			if (pinta.equals(mano[i].split("-")[0])) {
				contador++;
			}

		}
		b = (contador == 5) ? true : false;
		return b;
	}

	public boolean encontrarOrdenNumerico(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		for (int i = 0; i < listaNumerosOrdenada.size() - 1; i++) {
			if (listaNumerosOrdenada.get(i) != listaNumerosOrdenada.get(i + 1) - 1) {
				return false;
			}
		}
		return true;
	}

	public boolean royalFlush(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		if (isRoyalFlush(listaNumerosOrdenada)) {
			return true;
		}
		return false;
	}

	private int getIntValue(String valor) {
		int intValue = 0;
		switch (valor) {
		case "A":
			intValue = 1;
			break;
		case "2":
			intValue = 2;
			break;
		case "3":
			intValue = 3;
			break;
		case "4":
			intValue = 4;
			break;
		case "5":
			intValue = 5;
			break;
		case "6":
			intValue = 6;
			break;
		case "7":
			intValue = 7;
			break;
		case "8":
			intValue = 8;
			break;
		case "9":
			intValue = 9;
			break;
		case "10":
			intValue = 10;
			break;
		case "J":
			intValue = 11;
			break;
		case "Q":
			intValue = 12;
			break;
		case "K":
			intValue = 13;
			break;
		default:
			break;
		}
		return intValue;
	}

	private String getStringValue(int valor) {
		String stringValue = "";
		switch (valor) {
		case 1:
			stringValue = "A";
			break;
		case 2:
			stringValue = "2";
			break;
		case 3:
			stringValue = "3";
			break;
		case 4:
			stringValue = "4";
			break;
		case 5:
			stringValue = "5";
			break;
		case 6:
			stringValue = "6";
			break;
		case 7:
			stringValue = "7";
			break;
		case 8:
			stringValue = "8";
			break;
		case 9:
			stringValue = "9";
			break;
		case 10:
			stringValue = "10";
			break;
		case 11:
			stringValue = "J";
			break;
		case 12:
			stringValue = "Q";
			break;
		case 13:
			stringValue = "K";
			break;
		default:
			break;
		}
		return stringValue;
	}

	private boolean isRoyalFlush(List<Integer> lista) {
		if (lista.get(0) == 1 && lista.get(1) == 10 && lista.get(2) == 11 && lista.get(3) == 12 && lista.get(4) == 13) {
			return true;
		} else {
			return false;
		}
	}

	public List<Integer> arrayStringToListNumberSort(String[] mano) {
		List<Integer> listaNumeros = new ArrayList<Integer>();
		List<Integer> listaNumerosOrdenada = new ArrayList<Integer>();
		for (int i = 0; i < mano.length; i++) {
			int valor = getIntValue(mano[i].split("-")[1]);
			listaNumeros.add(valor);
		}
		listaNumerosOrdenada.addAll(listaNumeros.stream().sorted().collect(Collectors.toList()));
		return listaNumerosOrdenada;
	}

	public boolean encontrarCuatroIguales(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		for (Integer number : listaNumerosOrdenada) {
			int frecuencia = Collections.frequency(listaNumerosOrdenada, number);
//			log.info(number + " : " + frecuencia);
			if (frecuencia == 4) {
				return true;
			}
		}
		return false;
	}

	public boolean encontrarFullHouse(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		Map<Integer, Long> map = listaNumerosOrdenada.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Long[] numbers = map.values().toArray(new Long[map.values().size()]);
//		map.forEach((k, v) -> log.info(k + " : " + v));
		boolean trio = Arrays.stream(numbers).anyMatch(i -> i == 3);
		boolean par = Arrays.stream(numbers).anyMatch(i -> i == 2);
		return (trio && par) ? true : false;
	}

	public boolean encontrarTrio(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		Map<Integer, Long> map = listaNumerosOrdenada.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Long[] numbers = map.values().toArray(new Long[map.values().size()]);
//		map.forEach((k, v) -> log.info(k + " : " + v));
		boolean trio = Arrays.stream(numbers).anyMatch(i -> i == 3);
		return (trio);
	}

	public boolean encontrarDosPares(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		Map<Integer, Long> map = listaNumerosOrdenada.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Long[] numbers = map.values().toArray(new Long[map.values().size()]);
		int count = 0;
		for (int j = 0; j < numbers.length; j++) {
			if (numbers[j] == 2) {
				count++;
			}
		}
		return (count == 2);
	}

	public boolean encontrarUnPar(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		Map<Integer, Long> map = listaNumerosOrdenada.stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		Long[] numbers = map.values().toArray(new Long[map.values().size()]);
		int countPar = 0;
		int countResto = 0;
		for (int j = 0; j < numbers.length; j++) {
			if (numbers[j] == 2) {
				countPar++;
			}
			if (numbers[j] == 1) {
				countResto++;
			}
		}
		return (countPar == 1 && countResto == 3);
	}

	public String encontrarMasAlta(String[] mano) {
		List<Integer> listaNumerosOrdenada = arrayStringToListNumberSort(mano);
		int cartaAltaInt = Collections.max(listaNumerosOrdenada);
		String cartaAltaString = getStringValue(cartaAltaInt);
		return cartaAltaString;
	}
	
	public void desempate(Map<Integer, Integer> map, List<Jugador> listaJugadores, Integer par) {
//		log.info(map);
//		int count = 0;
//		Jugador j1 = null;
//		Jugador j2 = null;
//		map.keySet();
//		for(Entry<Integer, Integer> m: map.entrySet()) {
//			if(count == 0) {
//				j1 = listaJugadores.stream().findAny().filter(f -> f.getNumeroJugador() == m.getKey()).get();
//			}else {
//				j2 = listaJugadores.stream().findAny().filter(f -> f.getNumeroJugador() == m.getKey()).get();
//			}
//			count++;
//		}
//		List<Integer> mano1 = arrayStringToListNumberSort(j1.getMano());
//		List<Integer> mano2 = arrayStringToListNumberSort(j2.getMano());
		
		
//		for (int i = 0; i < map.keySet().toArray().length; i++) {
//			if(i == 0) {
//				j1 = (Jugador) listaJugadores.stream().filter(f -> f.getNumeroJugador() == map.get(0));
//			}else {
////				j2 = (Jugador) listaJugadores.stream().filter(f -> f.getNumeroJugador() == Integer.valueOf((String) numJ));
//			}
//			count++;
//		}
//		map.entrySet().stream().forEach(m -> {
//			listaJugadores.removeIf(r -> r.getNumeroJugador() == m.getKey());
//		});
//		listaJugadores.stream().forEach(j -> {
//			List<Integer> list = arrayStringToListNumberSort(j.getMano());
//			list.removeIf(r -> r == map.entrySet().stream().findFirst().get().getValue());
//			log.info(list);
//		});
	}
	
	
}
