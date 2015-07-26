package com.aa.monopoly;

import org.springframework.stereotype.Repository;

@Repository("stub")
public class StubSquareDao implements SquareDao {
	
	private static final String COMMUNITY_CHEST = "Community Chest";
	private static final String CHANCE = "Chance";

	
	private static final String[] SQUARE_NAMES = 
		   {"Go Square",
			"Mediterranean Ave",
			COMMUNITY_CHEST,
			"Baltic Ave",
			"Income Tax",
			"Reading Railroad",
			"Oriental Ave",
			CHANCE,
			"Vermont Ave",
			"Connecticut Ave",
			"Jail",
			"St. Charles Place",
			"Electric Company",
			"States Ave",
			"Virginia Ave",
			"Pennsylvania Railroad",
			"St. James Place",
			COMMUNITY_CHEST,
			"Tennessee Ave",
			"New York Ave",
			"Free Parking",
			"Kentucky Ave",
			CHANCE,
			"Indiana Ave",
			"Illinois Ave",
			"B. & O. Railroad",
			"Atlantic Ave",
			"Ventnor Ave",
			"Water Works",
			"Marvin Gardens",
			"Got to Jail",
			"Pacific Ave",
			"North Carolina Ave",
			COMMUNITY_CHEST,
			"Pennsylvania Ave",
			"Short Line Railroad",
			CHANCE,
			"Park Place",
			"Luxury Tax",
			"Boardwalk"};

	@Override
	public Square createSquare(int position) {
		Square square = null;
		switch (position) {
		case 0:
			square = new GoSquare();
			break;
		case 4:
			square = new IncomeTax();
			break;
		case  1: case  3: case  6: case  8: case  9: 
		case 11: case 13: case 14: case 16: case 18: case 19:
		case 21: case 23: case 24: case 26: case 27: case 29:
		case 31: case 32: case 34: case 37: case 39:
			square = new LotSquare(SQUARE_NAMES[position], position * 10, position);
			break;
		case 5: case 15: case 25: case 35:
			square = new RailRoadSquare(SQUARE_NAMES[position], 200);
			break;
		case 12: case 28:
			square = new UtilitySquare(SQUARE_NAMES[position], 150);
			break;
		case 38:
			square = new LuxuryTaxSquare();
			break;
		default:
			square = new Square(SQUARE_NAMES[position]);
			break;
		}
		return square;
	}
}
