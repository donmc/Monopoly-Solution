package com.aa.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRentingProperties {

	private Player owner;
	private Player renter;
	private Player utilOwner;

	@Before
	public void setup() {
		Board board = BoardFactory.getBoard();
		owner = new Player(Token.Battleship, board.getStartSquare());
		utilOwner = new Player(Token.Dog, board.getSquares().get(7));
		utilOwner.takeTurn(new LoadedDie(2), new LoadedDie(3));
		owner.takeTurn(new LoadedDie(5), new LoadedDie(6));
		
		renter = new Player(Token.Shoe, board.getStartSquare());
	}
	
	@Test
	public void shouldPayCorrectRentForLotSquare() {
		renter.takeTurn(new LoadedDie(5), new LoadedDie(6));
		assertEquals(1500-11, renter.getMoney());
		assertEquals(1500-110+11, owner.getMoney());
	}
	
	@Test
	public void shouldPayCorrectRentForUtilitySquare() {
		renter.takeTurn(new LoadedDie(4), new LoadedDie(3));
		renter.takeTurn(new LoadedDie(2), new LoadedDie(3));

		assertEquals(1500-20, renter.getMoney());
		assertEquals(1500-150+20, utilOwner.getMoney());
	}

}
