package com.aa.monopoly;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare() {
		super("Luxury Tax");
	}

	@Override
	public void landOnBy(Player p) {
		p.debit(75);
	} 

}
