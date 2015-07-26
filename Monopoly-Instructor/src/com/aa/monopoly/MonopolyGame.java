package com.aa.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.aa.dice.Die;

public class MonopolyGame {

	private Board board;
	private List<Player> players;
	private Die die1 = new Die();
	private Die die2 = new Die();
	private int round;
	private int numberOfRounds = 10;
	 
	public MonopolyGame(int numberOfPlayers, int numberOfRounds) {
		this(numberOfPlayers);
		this.numberOfRounds = numberOfRounds;
	}
	
	public MonopolyGame(int numberOfPlayers) {
		if (validNumberOfPlayers(numberOfPlayers)) {
			throw new IllegalArgumentException("Need between 2-8 players!");
		}
		board = BoardFactory.getBoard();
		
		createPlayers(numberOfPlayers);
	}

	private boolean validNumberOfPlayers(int numberOfPlayers) {
		return numberOfPlayers < 2 || numberOfPlayers > 8;
	}

	private void createPlayers(int numberOfPlayers) {
		players = new ArrayList<Player>();
		Square startSquare = board.getStartSquare();
		
		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new Player(Token.values()[i], startSquare));
		}
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void playRound() {
		round++;
		for (Player player : players) {
			player.takeTurn(die1, die2); 
		}
	}
	
	public int getRound() {
		return round;
	}
	
	public boolean isGameOver() {
		return round >= numberOfRounds;
	}

}
