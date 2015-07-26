package com.aa.monopoly.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Map<String, Command> commands = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		commands.put("new", new CreateGameCommand());
		commands.put("play", new PlayGameCommand());
	}
	
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String commandString	 = request.getParameter("cmd");
		if (commandString == null)
			commandString = "new";
		
		Command command = commands.get(commandString);
		
		String forward = command.execute(request, response);
		
		request.getRequestDispatcher(forward).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

}
