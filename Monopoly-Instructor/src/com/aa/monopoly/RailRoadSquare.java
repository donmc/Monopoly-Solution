package com.aa.monopoly;

public class RailRoadSquare extends PropertySquare {

	public RailRoadSquare(String name, int price) {
		super(name, price);
	}

	@Override
	protected int getRent(GamePlayer visitor) {
		return 25;
	}

}
