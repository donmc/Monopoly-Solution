package com.aa.monopoly;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("board")
@Scope("prototype")
public class Board {
	
	private SquareDao squareDao;

	private static final int NUM_OF_SQUARES = 40;
	private List<Square> squares = new ArrayList<Square>();

	public Board() {
		//injectDao();
		createSquares();
		linkSquares();
	}

	@Autowired
	public Board(@Qualifier("stub") SquareDao dao) {
		this.squareDao = dao;
		createSquares();
		linkSquares();
	}
	
	public void setSquareDao(SquareDao squareDao) {
		this.squareDao = squareDao;
	}

	private void linkSquares() {
		for (int i = 0; i < NUM_OF_SQUARES-1; i++) {
			Square currentSquare = squares.get(i);
			Square nextSquare    = squares.get(i+1);
			currentSquare.setNextSquare(nextSquare);
		}
		squares.get(squares.size()-1).setNextSquare(getStartSquare());
	}

	private void createSquares() {
		for (int i = 0; i < NUM_OF_SQUARES; i++) {
			Square square = squareDao.createSquare(i);
			squares.add(square);
		}
	}

	public List<Square> getSquares() {
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}

}
