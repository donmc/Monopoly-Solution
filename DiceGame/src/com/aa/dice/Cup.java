package com.aa.dice;

import java.util.ArrayList;
import java.util.List;

public class Cup {

	private List<Die> dice = new ArrayList<Die>();
	private int totalValue; 
	
	public Cup(int numberOfDice) {
		
		if(numberOfDice < 1)
			throw new IllegalArgumentException("Need More Dice!");
		
		for (int i = 0; i < numberOfDice; i++) {
			dice.add(new Die());
		}
	}

	public void shake() {
		for (Die die : dice) {
			totalValue += die.roll();
		}
	}

	public int getTotalValue() {
		return totalValue;
	}

}
