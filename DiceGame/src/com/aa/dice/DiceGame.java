package com.aa.dice;

public class DiceGame {

	public static void main(String[] args) {

		System.out.println("Welcome to my Dice Game!");
		
		Cup cup = new Cup(4);
		cup.shake();
				
		System.out.println("Cup rolled a " + cup.getTotalValue());
	}

}
