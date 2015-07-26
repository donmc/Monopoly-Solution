package com.aa.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.aa.dice.Die;

public class WhenMovingAroundBoard {

	@Test
	public void shouldMoveFromFirstSquare() {
		MonopolyGame game = new MonopolyGame(2);
		
		game.playRound();
		
		List<Player> players = game.getPlayers();
		Square firstSquare = game.getSquares().get(0);

		for (GamePlayer player : players) {
			assertNotEquals(firstSquare, player.getLocation());
		}
	}
	
	@Test
	public void shouldMoveCorrectNumberOfSpaces() {
		// Setup
		Board board = BoardFactory.getBoard();
		Player player = new Player(Token.Dog, board.getStartSquare());
		Die die1 = new LoadedDie(5);
		Die die2 = new LoadedDie(2);
		
		player.takeTurn(die1, die2);
		
		Square expectedLocation = board.getSquares().get(7);
		
		assertEquals(expectedLocation, player.getLocation());
	}
	
	@Test
	public void shouldWrapAroundBoard() {
		
		Board board = BoardFactory.getBoard();
		Player player = new Player(Token.Dog, board.getSquares().get(39));
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(4);
		
		player.takeTurn(die1, die2);
		
		Square expectedLocation = board.getSquares().get(5);
		
		assertEquals(expectedLocation, player.getLocation());
	}

}
