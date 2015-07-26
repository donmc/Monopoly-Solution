package com.aa.monopoly;

public abstract class PropertySquare extends Square {

	private int price;
	private Player owner;

	public PropertySquare(String name, int price) {
		super(name);
		this.price = price;
	}

	@Override
	public void landOnBy(Player visitor) {
		if(owner == null) {
			purchaseProperty(visitor);
		} else {
			collectRent(visitor);
		}
	}

	private void collectRent(Player visitor) {
		visitor.debit(getRent(visitor));
		owner.credit(getRent(visitor));
	}

	private void purchaseProperty(Player visitor) {
		if (visitor.getMoney() >= price) {
			visitor.debit(price);
			this.owner = visitor;
		}
	}

	protected abstract int getRent(GamePlayer visitor);

	public GamePlayer getOwner() {
		return owner;
	}

}
