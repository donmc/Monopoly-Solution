package com.aa.monopoly;

public class Square {

	private Square nextSquare;
	private String name;
	
	public Square(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Square getNextSquare() {
		return nextSquare;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public void landOnBy(Player p) {
		
	}

	public void passOverby(Player player) {
		
	}
}
