package cs361.battleships.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	//Initialize private members for game variables
	private List<Ship> ships;		//List of ships on the board
	private List<Result> attacks;	//List of all result objects (one per turn/attack)

	//we keep track of the board's height and width.
	private int height; private int width;

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		ships = new ArrayList<>();
		attacks = new ArrayList<>();
		//current, and only board configuration is 10x10
		this.height = 10;
		this.width = 10;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		// TODO Implement
		return false;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Square target = new Square(x, y);
		Result rezz = new Result();
		for (Ship placed : this.getShips()) {                             //cycle through all ships
			for (Square filled : placed.getOccupiedSquares()) {     //cycle through every square those ships occupy
				if (filled.equals(target)) {                   //break on a conflict
					rezz.setResult(AtackStatus.HIT);
					return rezz;
				}
			}
		}
		rezz.setResult(AtackStatus.MISS);
		return rezz;
	}

	public List<Ship> getShips() {
		return this.ships;
	}

	public void setShips(List<Ship> ships) {
		//TODO implement
	}

	public List<Result> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
		//TODO implement
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}
}
