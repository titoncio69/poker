package com.poker.backend.rest.service;

public interface IManosPokerService {

	// Mejor Mano 10-J-Q-K-A
	Boolean royalFlush(String[] mano);

	// Straight Flush
	Boolean straightFlush(String[] mano);

	// Four of a Kind
	Boolean fourOfAKind(String[] mano);

	// Full house
	Boolean fullHouse(String[] mano);

	// Flush
	Boolean flush(String[] mano);

	// Straight
	Boolean Straight(String[] mano);

	// Three of a kind
	Boolean threeOfAKind(String[] mano);

	// Two pair
	Boolean twoPair(String[] mano);

	// One pair
	Boolean onePair(String[] mano);

	// High card
	String highCard(String[] mano);
}
