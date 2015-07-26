package com.aa.monopoly;

import com.aa.dice.Die;

public class LoadedDie extends Die {

	private int loadedSide;

	public LoadedDie(int loadedSide) {
		this.loadedSide = loadedSide;
	}
	
	@Override
	public int roll() {
		
		return loadedSide;
	}
	
	@Override
	public int getFaceValue() {
		return loadedSide;
	}

}
