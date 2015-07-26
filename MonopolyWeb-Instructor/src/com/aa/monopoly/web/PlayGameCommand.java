package com.aa.monopoly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aa.monopoly.MonopolyGame;

public class PlayGameCommand implements Command {

	@Override 
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		MonopolyGame game = (MonopolyGame) session.getAttribute("game");
		
		game.playRound();
		
		return "/game.jsp";
	}

}
