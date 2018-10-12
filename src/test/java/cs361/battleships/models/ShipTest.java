package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;



public class ShipTest {

    @Test
    public void testShipConstructor() {
        Ship ship = new Ship("Battleship");
        assertTrue(ship != null);
    }

    public void testShipGetter(){
        Ship ship = new Ship("BATTLESHIP");
        assertNotNull(ship.getOccupiedSquares());
    }
}
