package com.aa.monopoly.ui;

import java.util.List;

import com.aa.monopoly.GamePlayer;
import com.aa.monopoly.MonopolyGame;
import com.aa.monopoly.Player;
import com.aa.monopoly.StubSquareDao;

public class GameApp {

	public static void main(String[] args) {

		MonopolyGame game = new MonopolyGame(2);
		List<Player> players = game.getPlayers();
		 
		for (int i = 0; i < 10; i++) {
			game.playRound();
			System.out.println("******* Round " + (i+1) + " *******");
			
			for (GamePlayer player : players) {
				System.out.println(player.getToken() + " rolled a " + player.getLastRoll());
				System.out.println(player.getToken() + " landed on " + player.getLocation().getName());
				System.out.println(player.getToken() + " has $" + player.getMoney());
			}
		}
		
	}

}
