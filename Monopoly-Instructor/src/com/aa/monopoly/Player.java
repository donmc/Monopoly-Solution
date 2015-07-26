package com.aa.monopoly;

import com.aa.dice.Die;

public class Player implements GamePlayer {
 
	private Token token;
	private Square location;
	private int money;
	private int die1FaceValue;
	private int die2FaceValue;

	public Player(Token token, Square startSquare) {
		this.token = token;
		this.location = startSquare;
		this.money = 1500;
	}

	/* (non-Javadoc)
	 * @see com.aa.monopoly.GamePlayer#getToken()
	 */
	@Override
	public Token getToken() {
		return token;
	}

	/* (non-Javadoc)
	 * @see com.aa.monopoly.GamePlayer#getLocation()
	 */
	@Override
	public Square getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see com.aa.monopoly.GamePlayer#getMoney()
	 */
	@Override
	public int getMoney() {
		return money;
	}

	public void takeTurn(Die die1, Die die2) {
		die1.roll();
		die2.roll();
		die1FaceValue = die1.getFaceValue();
		die2FaceValue = die2.getFaceValue();
		
		move();
	}

	private void move() {
		for (int i = 0; i < getLastRoll()-1; i++) {
			step();
			location.passOverby(this);
		}
		step();
		location.landOnBy(this);
	}

	private void step() {
		location = location.getNextSquare();
	}

	/* (non-Javadoc)
	 * @see com.aa.monopoly.GamePlayer#getLastRoll()
	 */
	@Override
	public int getLastRoll() {
		return die1FaceValue + die2FaceValue;
	}

	public void credit(int amount) {
		this.money += amount;		
	}

	public void debit(int amount) {
		this.money -= amount;
	}
	
	public int getDie1FaceValue() {
		return die1FaceValue;
	}
	
	public int getDie2FaceValue() {
		return die2FaceValue;
	}

}
