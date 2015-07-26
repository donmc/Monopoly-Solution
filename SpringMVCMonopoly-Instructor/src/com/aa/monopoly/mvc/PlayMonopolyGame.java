package com.aa.monopoly.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aa.monopoly.MonopolyGame;

@Controller
public class PlayMonopolyGame {

	@RequestMapping("/playRound")
	public String playRound(Model model, HttpSession session) {
		MonopolyGame game = (MonopolyGame) session.getAttribute("game");
		game.playRound();
		PlayGameBean playGameBean = new PlayGameBean();
		playGameBean.setCurrentRound(game.getRound());
		playGameBean.setPlayers(game.getPlayers());
		playGameBean.setGameOver(game.isGameOver());
		
		model.addAttribute("playGameBean", playGameBean);
		
		return "game";
	}
}
