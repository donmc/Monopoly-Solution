package com.aa.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnPropertySquares {
	
	private Player player;
	private Player owner;

	@Before
	public void setup() {
		Board board = BoardFactory.getBoard();
		player = new Player(Token.Shoe, board.getStartSquare());
		owner = new Player(Token.Car, board.getStartSquare());
		owner.takeTurn(new LoadedDie(5), new LoadedDie(4));
	}

	@Test
	public void shouldPurchaseAffordableProperty() {
		PropertySquare property = (PropertySquare) owner.getLocation();
		
		assertEquals(1500-90, owner.getMoney());
		assertEquals(owner, property.getOwner());
	}
	
	@Test
	public void shouldNotPurchaseUnaffordableProperty() {
		player.debit(1450);
		
		player.takeTurn(new LoadedDie(5), new LoadedDie(3));
		PropertySquare property = (PropertySquare) player.getLocation();
		
		assertEquals(50, player.getMoney());
		assertNull(property.getOwner());
	}
	
	@Test
	public void shouldNotPurchaseOwnedProperty() {
		player.takeTurn(new LoadedDie(5), new LoadedDie(4));
		PropertySquare property = (PropertySquare) player.getLocation();
		
		assertNotEquals(player, property.getOwner());
	}

}
