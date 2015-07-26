package com.aa.monopoly.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aa.monopoly.MonopolyGame;
import com.aa.monopoly.Player;

/**
 * Servlet implementation class MonopolyServlet
 */
public class MonopolyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MonopolyGame game = (MonopolyGame) session.getAttribute("game");
		
		game.playRound();
		
		request.getRequestDispatcher("/game.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
