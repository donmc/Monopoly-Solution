package com.aa.monopoly.web;

import java.util.List;

import com.aa.monopoly.MonopolyGame;
import com.aa.monopoly.Player;

public class GameBean {

	private MonopolyGame game;
	private int roundLimit;
	private int defaultNumberOfPlayers;
	private String errors;
	
	public GameBean() {
	}
	
	public GameBean(MonopolyGame game) {
		this.game = game;
	}
	
	
	public List<Player> getPlayers() {
		return game.getPlayers();
	}
	
	public int getCurrentRound() {
		return game.getRound();
	}
	
	public boolean isGameOver() {
		return game.getRound() >  roundLimit;
	}
	
	public void setDefaultNumberOfPlayers(int defaultNumberOfPlayers) {
		this.defaultNumberOfPlayers = defaultNumberOfPlayers;
	}
	
	public int getDefaultNumberOfPlayers() {
		return defaultNumberOfPlayers;
	}
	
	public void setRoundLimit(int roundLimit) {
		this.roundLimit = roundLimit;
	}
	
	public int getRoundLimit() {
		return roundLimit;
	}

	public void setGame(MonopolyGame game) {
		this.game = game;
	}
	
	public String getErrors() {
		return errors;
	}
	
	public void setErrors(String errors) {
		this.errors = errors;
	}
}
