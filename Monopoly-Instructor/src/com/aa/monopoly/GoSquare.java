package com.aa.monopoly;

public class GoSquare extends Square {

	public GoSquare() {
		super("Go Square");
	}

	@Override
	public void landOnBy(Player player) {
		creditPlayer(player);
	}

	private void creditPlayer(Player player) {
		player.credit(200);
	} 

	@Override
	public void passOverby(Player player) {
		creditPlayer(player);
	}
	
}
