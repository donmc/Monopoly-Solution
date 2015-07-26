package com.aa.monopoly.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aa.monopoly.MonopolyGame;

/**
 * Servlet implementation class CreateGameServlet
 */
public class CreateGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forward = "/index.jsp";
		String errorMessage = null;
		String numberOfPlayers = request.getParameter("numberOfPlayers");
		String roundLimit = request.getParameter("roundLimit");
		String defaultNumberOfPlayers = getServletContext().getInitParameter("defaultNumberOfPlayers");
		
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
				forward = "/play";
			} catch (IllegalArgumentException e) {
				errorMessage = e.getMessage();
			} 
		}
		gameBean.setErrors(errorMessage);
		request.getRequestDispatcher(forward).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
