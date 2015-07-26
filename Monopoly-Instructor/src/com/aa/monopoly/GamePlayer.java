package com.aa.monopoly;

public interface GamePlayer {

	public abstract Token getToken();

	public abstract Square getLocation();

	public abstract int getMoney();

	public abstract int getLastRoll();

}