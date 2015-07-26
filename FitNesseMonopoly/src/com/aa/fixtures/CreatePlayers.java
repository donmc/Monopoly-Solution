package com.aa.fixtures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aa.monopoly.MonopolyGame;
import com.aa.monopoly.Player;

public class CreatePlayers {
	private MonopolyGame game;

	public CreatePlayers(int numberOfPlayers) {
		game = new MonopolyGame(numberOfPlayers);
	}
	
	public List<Object> query() {
		List<Object> tableList = new ArrayList<Object>();
		List<Player> players = game.getPlayers();
		
		for (Player player : players) {
			List<String> tokenList = Arrays.asList(new String[]{"token",player.getToken().name()});
			List<String> moneyList = Arrays.asList(new String[]{"money",""+player.getMoney()});
			List<String> locationList = Arrays.asList(new String[]{"location",player.getLocation().getName()});
			List<List<String>> rowList = new ArrayList<List<String>>();
			rowList.add(tokenList);
			rowList.add(moneyList);
			rowList.add(locationList);
			tableList.add(rowList);
		}
		
		return tableList;
	}
}
