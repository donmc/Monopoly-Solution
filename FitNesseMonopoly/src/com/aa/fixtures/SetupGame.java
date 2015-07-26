package com.aa.fixtures;

import com.aa.monopoly.MonopolyGame;


public class SetupGame {
	private int numberOfPlayers;
	private int numberOfRounds;
	
	private MonopolyGame game;
	private String message;
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}
	
	public boolean success() {
		try {
			game = new MonopolyGame(numberOfPlayers, numberOfRounds);
			System.out.println("Created game with" + numberOfPlayers + " players");
		} catch (Exception e) {
			this.message = e.getMessage();
			return false;
		}
		
		return true;
	}
	
	public String message() {
		return message;
	}
	
	public int numberOfPlayersCreated() {
		return game.getPlayers().size();
	}
	
	public int numberOfSquares() {
		return game.getSquares().size();
	}
}
