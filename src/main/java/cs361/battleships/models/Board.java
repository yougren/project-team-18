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

		this.ships = new ArrayList<>();
		this.attacks = new ArrayList<>();
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		//passed square is the top-left of the ship (depending on orientation)
		//we must check to make sure the squares are not occupied

		List<Square> candidate = ship.getOccupiedSquares();

		//generate a candidate array of locations
		for(int i = 0; i < ship.getLength(); i++) {

		    //generate coordinates for new squares
			int XC = x + (isVertical ? i : 0);
			int YC = ((int)y + (isVertical ? 0 : i) - (int)'A' + 1);  //must convert out of unicode

			//make sure the ship is within the bounds of the board
			if (XC > this.width || XC < 1 || YC > this.height || YC < 1) { return false; }

			candidate.add(new Square(XC, (char)(YC - 1 + 'A')));
		}

		//ensure the ship is not conflicting with another ship
         for(Ship placed : this.ships) {                             //cycle through all ships
            for (Square filled : placed.getOccupiedSquares()) {     //cycle through every square those ships occupy
                for (Square attempt : candidate) {                  //cycle through every square we want to add.
                    if (filled.getColumn() == attempt.getColumn() && filled.getRow() == attempt.getRow()) {                   //break on a conflict
                        return false;
                    }
                }
            }
         }

		//there were no conflicts, so sync the ship squares and add the ship
		ship.setOccupiedSquares(candidate);
		this.ships.add(ship);

		return true;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Result attack(int x, char y) {
		Square target = new Square(x, y);
		Result rezz = new Result();

		//check against board dimensions
		if(x < 1 || x > 10 || y < 'A' || y > 'J'){
			rezz.setResult(AtackStatus.INVALID);
			return rezz;
		}

		//check against previous attacks
		for (Result att : this.attacks) {
		    Square filled = att.getLocation();
            if (filled.getColumn() == target.getColumn() && filled.getRow() == target.getRow()) {   //it is a hit
                rezz.setResult(AtackStatus.INVALID);
                return rezz;
            }
        }

        //check against ships to see if hit
        rezz.setLocation(target);
		for (Ship placed : this.getShips()) {                             //cycle through all ships
			for (Square filled : placed.getOccupiedSquares()) {     //cycle through every square those ships occupy
				if (filled.getColumn() == target.getColumn() && filled.getRow() == target.getRow()) {   //it is a hit
					rezz.setResult(AtackStatus.HIT);
					rezz.setShip(placed);
					this.attacks.add(rezz);
					return rezz;
				}
			}
		}

		this.attacks.add(rezz);
		rezz.setResult(AtackStatus.MISS);
		return rezz;
	}

	public List<Ship> getShips() {
		return this.ships;
	}

	public void setShips(List<Ship> ships) {
	    this.ships = ships;
	}

	public List<Result> getAttacks() {
		return this.attacks;
	}

	public void setAttacks(List<Result> attacks) {
	    this.attacks = attacks;
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
