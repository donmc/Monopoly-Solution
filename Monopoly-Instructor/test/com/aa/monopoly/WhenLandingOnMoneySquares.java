package com.aa.monopoly;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenLandingOnMoneySquares {

	private Board board;
	@Before
	public void setup() {
		board = new Board(new StubSquareDao());
	}
	
	@Test
	public void shouldCollect200ForLandingOnGo() {
		Player player = new Player(Token.Hat, board.getSquares().get(35));
		
		player.takeTurn(new LoadedDie(3), new LoadedDie(2));
		
		assertEquals(1500 + 200, player.getMoney());
	}
	
	@Test
	public void shouldPay75ForLandingOnLuxuryTax() {
		Player player = new Player(Token.Hat, board.getSquares().get(35));
		
		player.takeTurn(new LoadedDie(1), new LoadedDie(2));
		
		assertEquals(1500-75, player.getMoney());
	}
	
	@Test
	public void shouldPay10PercentForLandingOnIncomeTaxWhenPoor() {
		Player player = new Player(Token.Hat, board.getStartSquare());
		
		player.takeTurn(new LoadedDie(3), new LoadedDie(1));
		
		assertEquals(1500-150, player.getMoney());
		
	}

	@Test
	public void shouldPay200MaxForLandingOnIncomeTaxWhenRich() {
		Player player = new Player(Token.Hat, board.getStartSquare());
		player.credit(1500);
		player.takeTurn(new LoadedDie(3), new LoadedDie(1));
		
		assertEquals(3000-200, player.getMoney());
	}
	
	@Test
	public void shouldCollect200ForPassingGo() {
		Player player = new Player(Token.Hat, board.getSquares().get(35));
		
		player.takeTurn(new LoadedDie(3), new LoadedDie(3));
		
		assertEquals(1500 + 200 - 10, player.getMoney());
	}
}
