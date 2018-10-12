package cs361.battleships.models;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class BoardTest {

    @Test
    public void testBoardConstructor() {
        Board board = new Board();
        assertTrue(board instanceof Board);
    }

    @Test
    public void testBoardHeightInitial() {
        Board board = new Board();
        assertEquals(board.getHeight(), 10);
        assertEquals(board.getWidth(), 10);
    }

    @Test
    public void testBoardHeightSet() {
        Board board = new Board();
        int testHeight = 230;
        board.setHeight(testHeight);
        int setHeight = board.getHeight();
        assertEquals(testHeight, setHeight);
    }

    @Test
    public void testBoardWidthSet() {
        Board board = new Board();
        int testWidth = 167;
        board.setWidth(testWidth);
        int setWidth = board.getWidth();
        assertEquals(testWidth, setWidth);
    }
}
