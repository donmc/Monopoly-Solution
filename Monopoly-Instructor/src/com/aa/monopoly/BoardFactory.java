package com.aa.monopoly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardFactory {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	public static Board getBoard() {
				
		return context.getBean("board",Board.class);
	}
}
