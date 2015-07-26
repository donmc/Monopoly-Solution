package com.aa.monopoly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aa.monopoly.MonopolyGame;

public class CreateGameCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String forward = "/index.jsp";
		String errorMessage = null;
		String numberOfPlayers = request.getParameter("numberOfPlayers");
		String roundLimit = request.getParameter("roundLimit");
		String defaultNumberOfPlayers = request.getServletContext().getInitParameter("defaultNumberOfPlayers");
		
		HttpSession session = request.getSession();
		
		GameBean gameBean = (GameBean) session.getAttribute("gameBean");
		
		if (gameBean == null ) {
			gameBean = new GameBean();
			session.setAttribute("gameBean", gameBean);
			gameBean.setDefaultNumberOfPlayers(Integer.parseInt(defaultNumberOfPlayers));
		}
		
		if (numberOfPlayers != null) {
			try {
				MonopolyGame game = new MonopolyGame(Integer.parseInt(numberOfPlayers));
				session.setAttribute("game", game);
				gameBean.setGame(game);
				gameBean.setRoundLimit(Integer.parseInt(roundLimit));
				forward = "/controller?cmd=play";
			} catch (IllegalArgumentException e) {
				errorMessage = e.getMessage();
			} 
		}
		gameBean.setErrors(errorMessage);
		
		return forward;
	}

}
