package com.aa.monopoly;

public class IncomeTax extends Square {

	public IncomeTax() {
		super("Income Tax");
	}

	@Override
	public void landOnBy(Player p) {
		int money = p.getMoney();
		p.debit(Math.min(money/10, 200));
	} 

}
