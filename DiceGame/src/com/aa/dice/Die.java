package com.aa.dice;

import java.util.Random;

public class Die {

	private int faceValue;
	
	public Die() {
		roll(); 
	}

	public int roll() {
		Random random = new Random();
		
		this.faceValue = random.nextInt(6) + 1; 
		
		return faceValue;
	}
	
	public int getFaceValue() {
		return faceValue;
	}

}
