package cs361.battleships.models;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static junit.framework.TestCase.*;

public class BoardTest {


    public Dock getDock() {
        Dock dock = new Dock();
        dock.registerClass("BATTLESHIP", Battleship.class);
        dock.registerClass("DESTROYER", Destroyer.class);
        dock.registerClass("MINESWEEPER", Minesweeper.class);
        return dock;
    }

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
        Dock dock = this.getDock();
        try {
            Ship ship = dock.deploy("BATTLESHIP");
            assertTrue(board.placeShip(ship, 8, 'A', false));
            assertTrue(board.getShips().size() > 0);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testBoardConflictPlaceShip() {
        Board board = new Board();
        Dock dock = this.getDock();
        try {
            //initialize our ships for testing
            Ship destroyer = dock.deploy("DESTROYER");
            Ship mine = dock.deploy("MINESWEEPER");
            Ship battle = dock.deploy("BATTLESHIP");

            //place the first ship, there should be no issue here
            boolean placeInitial = board.placeShip(destroyer, 5, 'D', false);
            assertTrue(placeInitial);

            //place the second ship starting on the same square
            boolean placeConflict = board.placeShip(mine, 5, 'D', true);
            assertFalse(placeConflict);

            //place another ship so the end of it is crossing the first ship
            boolean placeConflictEnd = board.placeShip(battle, 5, 'C', false);
            assertFalse(placeConflictEnd);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testBoardOutOfBoundsPlaceShip() {
        Board board = new Board();
        Dock dock = this.getDock();
        try {
            //initialize our ships for testing
            Ship destroyer = dock.deploy("DESTROYER");
            Ship cruiser = dock.deploy("BATTLESHIP");

            //place outside the board
            boolean placeOut = board.placeShip(destroyer, 15, 'D', false);
            assertFalse(placeOut);

            //place so end is outside
            boolean placeEndOut = board.placeShip(cruiser, 10, 'J', true);
            assertFalse(placeEndOut);
        } catch (Exception e) {
            assertTrue(false);
        }
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
        Board board = new Board();
        Dock dock = this.getDock();
        try {
            Ship ship = dock.deploy("destroyer");
            board.placeShip(ship, 5, 'd', true);
            assertTrue(board.attack(5, 'd').getResult() == AttackStatus.HIT);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
