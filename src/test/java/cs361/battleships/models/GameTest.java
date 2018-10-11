package cs361.battleships.models;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameTest {

    @Test
    public void testRandomColumn(){
        Game game = new Game();
        int randcol = (int)game.randCol();
        assertTrue(randcol >= 65 && randcol <= 73);
    }

    @Test
    public void testRandomRow(){
        Game game = new Game();
        int randrow = game.randRow();
        assertTrue(randrow >= 1 && randrow <= 10);
    }

    @Test
    public void testRandomVertical(){
        Game game = new Game();
        boolean vertical = game.randVertical();
        assertTrue(String.valueOf(vertical).equals("true") || String.valueOf(vertical).equals("false"));
    }
}
