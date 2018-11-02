package cs361.battleships.models;

public class Result {

	private AttackStatus result;
	private Square location;
	private Ship ship;

	public AttackStatus getResult() {
		return this.result;
	}

	public void setResult(AttackStatus result) {
		this.result = result;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Square getLocation() {
		return this.location;
	}

	public void setLocation(Square square) {
		this.location = square;
	}
}
