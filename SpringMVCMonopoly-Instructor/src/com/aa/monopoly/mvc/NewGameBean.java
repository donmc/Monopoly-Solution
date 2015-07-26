package com.aa.monopoly.mvc;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

public class NewGameBean {

	@Range(min=2, max=8)
	private int numberOfPlayers;
	
	@Min(value=1)
	private int numberOfRounds;
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getNumberOfRounds() {
		return numberOfRounds;
	}
	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}
	
	
}
