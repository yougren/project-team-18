package cs361.battleships.models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ShipTest {

    @Test
    public void testShipConstructor(){
        Ship ship = new Ship("Battleship");
        assertTrue(ship != null);
    }
}
