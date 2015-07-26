package com.aa.monopoly.mvc;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aa.monopoly.MonopolyGame;


@Controller
public class NewMonopolyGame {

	@RequestMapping(value = {"/", "/home"})
	public String setupNewGame(Model model) {
		NewGameBean newGameBean = new NewGameBean();
		newGameBean.setNumberOfPlayers(2);
		newGameBean.setNumberOfRounds(10);
		model.addAttribute("newGameBean", newGameBean);
		return "index";
	}
	
	@RequestMapping("/startGame")
	public String startGame(@Valid NewGameBean newGameBean, BindingResult result, HttpSession session) {
		
		if (result.hasErrors()) {
			return "index";
		}
		
		try {
			MonopolyGame game = 
					new MonopolyGame(newGameBean.getNumberOfPlayers(), newGameBean.getNumberOfRounds());
			session.setAttribute("game", game);
		} catch (IllegalArgumentException e) {
			result.addError(new FieldError("newGameBean", "numberOfPlayers", e.getMessage()));
			return "index";
		}
		
		return "forward:playRound";
	}
}
