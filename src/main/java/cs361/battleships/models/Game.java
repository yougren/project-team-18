package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Game {

    @JsonProperty private Board playersBoard = new Board();
    @JsonProperty private Board opponentsBoard = new Board();
    private static Random rand = new Random();
    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
        return playersBoard.placeShip(ship, x, y, isVertical);
    }

    public boolean placeShip(Ship ship) {
        boolean opponentPlacedSuccessfully;
        do {
            // AI places random ships, so it might try and place overlapping ships
            // let it try until it gets it right
            opponentPlacedSuccessfully = opponentsBoard.placeShip(ship, randRow(), randCol(), randVertical());
        } while (!opponentPlacedSuccessfully);

        return true;
    }

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean attack(int x, char  y) {
        return opponentsBoard.attack(x, y).getResult() != AttackStatus.INVALID;
    }

    public boolean attack() {
        boolean attackFail;
        do {
            // AI does random attacks, so it might attack the same spot twice
            // let it try until it gets it right
            attackFail = playersBoard.attack(randRow(), randCol()).getResult() == AttackStatus.INVALID;
        } while(attackFail);

        return true;
    }

    public static char randCol() {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J'};
        return alphabet[rand.nextInt(10)];
    }

    public static int randRow() {
        return rand.nextInt(10) + 1;
    }

    public static boolean randVertical() {
        return rand.nextBoolean();
    }
}
