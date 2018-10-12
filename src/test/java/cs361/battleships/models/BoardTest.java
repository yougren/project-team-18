package cs361.battleships.models;

import java.util.List;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class BoardTest {

    @Test
    public void testBoardConstructor() {
        Board board = new Board();

        //Simple typecheck for board instantiation (not NULL at least)
        assertTrue(board instanceof Board);
    }

    @Test
    public void testBoardHeightInitial() {
        //Initialize board
        Board board = new Board();

        //Make sure default values are being set correctly.
        assertEquals(board.getHeight(), 10);
        assertEquals(board.getWidth(), 10);
    }

    @Test
    public void testBoardEmptyPlaceShip() {
        Board board = new Board();
        Ship ship = new Ship("DESTROYER");
        assertTrue(board.placeShip(ship, 8, 'A', false));
    }

    @Test
    public void testBoardConflictPlaceShip() {
        Board board = new Board();

        //initialize our ships for testing
        Ship destroyer = new Ship("DESTROYER");
        Ship mine = new Ship("MINESWEEPER");
        Ship battle = new Ship("BATTLESHIP");

        //place the first ship, there should be no issue here
        boolean placeInitial = board.placeShip(destroyer, 5, 'D', false);
        assertTrue(placeInitial);

        //place the second ship starting on the same square
        boolean placeConflict = board.placeShip(mine, 5, 'D', true);
        assertFalse(placeConflict);

        //place another ship so the end of it is crossing the first ship
        boolean placeConflictEnd = board.placeShip(battle, 5, 'C', false);
        assertFalse(placeConflictEnd);
    }

    @Test
    public void testBoardOutOfBoundsPlaceShip() {
        Board board = new Board();
        Ship destroyer = new Ship("DESTROYER");
        Ship cruiser = new Ship("BATTLESHIP");

        //place outside the board
        boolean placeOut = board.placeShip(destroyer, 15, 'D', false);
        assertFalse(placeOut);

        //place so end is outside
        boolean placeEndOut = board.placeShip(cruiser, 10, 'J', true);
        assertFalse(placeEndOut);
    }

    @Test
    public void testBoardHeightSet() {
        //Initialize board
        Board board = new Board();

        //Create test height and set it on the board
        int testHeight = 230;
        board.setHeight(testHeight);

        //Get the height and check that it is the same
        int setHeight = board.getHeight();
        assertEquals(testHeight, setHeight);
    }

    @Test
    public void testBoardWidthSet() {
        //Initialize board
        Board board = new Board();

        //Set width for testing
        int testWidth = 167;
        board.setWidth(testWidth);

        //Get width, and make sure it is the same
        int setWidth = board.getWidth();
        assertEquals(testWidth, setWidth);
    }

    @Test
    public void TestAttack(){
//        Ship ship = new Ship("destroyer");
//        Board board = new Board();
//        board.placeShip(ship, 5, 'd', true);
//        assertTrue(board.attack(5, 'd').getResult() == AtackStatus.HIT);
    }
}
