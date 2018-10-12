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
