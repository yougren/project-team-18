package cs361.battleships.models;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class ShipTest {

    @Test
    public void test(){
        Ship ship = new Ship("BATTLESHIP");
        assertNotNull(ship.getOccupiedSquares());
    }
}
