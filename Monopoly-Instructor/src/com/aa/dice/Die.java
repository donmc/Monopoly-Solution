package com.aa.dice;

import java.util.Random;

public class Die {

	private int faceValue;
	private Random random = new Random();
	
	public Die() {
		roll(); 
	}

	public int roll() {
		
		this.faceValue = random.nextInt(6) + 1; 
		
		return faceValue;
	}
	
	public int getFaceValue() {
		return faceValue;
	}

}
