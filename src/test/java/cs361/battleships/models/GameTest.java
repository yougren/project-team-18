package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class GameTest {

    @Test
    public void testRandomColumn(){
        Game game = new Game();
        int randcol = (int)game.randCol();
        //implicit int-char comparison converts 'I' and 'A' to their respective ascii values
        assertTrue(randcol <= 'I');
        assertTrue(randcol >= 'A');
    }

    @Test
    public void testRandomRow(){
        Game game = new Game();
        int randrow = game.randRow();
        assertTrue(randrow >= 1);
        assertTrue(randrow <= 10);
    }
}
