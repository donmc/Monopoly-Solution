package mypackage;

import org.apache.struts.action.ActionForm;

public class CreateGameForm extends ActionForm {
	private int numberOfPlayers;
	private int roundLimit;
	private boolean newGame = true;
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	public int getRoundLimit() {
		return roundLimit;
	}
	public void setRoundLimit(int roundLimit) {
		this.roundLimit = roundLimit;
	}
	public boolean isNew() {
		return newGame;
	}
	public void setNew(boolean play) {
		this.newGame = play;
	}
	
	
	
}
