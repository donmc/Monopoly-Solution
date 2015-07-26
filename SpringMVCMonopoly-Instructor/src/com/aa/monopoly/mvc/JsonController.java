package com.aa.monopoly.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aa.monopoly.Token;

@Controller
public class JsonController {

	@RequestMapping("/tokens")
	public List<Token> tokens(@RequestParam int numberOfTokens) {
		List<Token> tokens = new ArrayList<Token>();
		for (int i = 0; i < numberOfTokens && i < Token.values().length; i++) {
			tokens.add(Token.values()[i]);
			
		}
		return tokens;
	}
	
}
