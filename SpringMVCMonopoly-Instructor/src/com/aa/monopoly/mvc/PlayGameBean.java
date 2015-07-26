package com.aa.monopoly.mvc;

import java.util.List;

import com.aa.monopoly.Player;

public class PlayGameBean {

	private int currentRound;
	private List<Player> players;
	private boolean gameOver;
	
	public int getCurrentRound() {
		return currentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
}
