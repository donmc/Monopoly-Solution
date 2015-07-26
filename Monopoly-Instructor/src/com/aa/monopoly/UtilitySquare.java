package com.aa.monopoly;

public class UtilitySquare extends PropertySquare {

	public UtilitySquare(String name, int price) {
		super(name, price);
	}

	@Override
	protected int getRent(GamePlayer visitor) {
		return visitor.getLastRoll() * 4;
	}

}
