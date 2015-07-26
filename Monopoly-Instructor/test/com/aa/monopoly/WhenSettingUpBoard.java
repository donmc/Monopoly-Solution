package com.aa.monopoly;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class WhenSettingUpBoard {

	@Test
	public void shouldHave40Squares() { 
		//setup + exercise
		MonopolyGame game = new MonopolyGame(2);
		
		//validate
		List<Square> squares = game.getSquares();
		assertEquals(40, squares.size());
	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		//setup
		int numberOfPlayers = 4;
		MonopolyGame game = new MonopolyGame(numberOfPlayers);
		
		List<Player> players = game.getPlayers();
		
		assertEquals(numberOfPlayers, players.size());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAllowForLessThan2Players() {
		new MonopolyGame(1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAllowForMoreThan8Players() {
		new MonopolyGame(9);
	}
	
	@Test
	public void shouldHaveCorrectTokens() {

		MonopolyGame game = new MonopolyGame(4);
		
		String[] tokens = {"Car", "Shoe", "Dog", "Hat"};

		List<Player> players = game.getPlayers();
		
		for (int i = 0; i < players.size(); i++) {
			assertEquals(tokens[i], players.get(i).getToken().toString());
			
		}
	}
	
	@Test
	public void shouldStartPlayersOnFirstSquare(){

		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Square firstSquare = game.getSquares().get(0);
		
		for (GamePlayer player : players) {
			assertEquals(firstSquare, player.getLocation());
		}
		
	}
	
	@Test
	public void shouldStartPlayersWith1500() {

		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		
		for (GamePlayer player : players) {
			assertEquals(1500, player.getMoney());
		}
	}
}





