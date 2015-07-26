package com.aa.monopoly;

public class LotSquare extends PropertySquare {

	private int rent;

	public LotSquare(String name, int price, int rent) {
		super(name, price);
		this.rent = rent;
	}

	@Override
	protected int getRent(GamePlayer visitor) {
		return rent;
	}

}
