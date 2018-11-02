package cs361.battleships.models;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;



public class ShipTest {

    public Dock getDock() {
        Dock dock = new Dock();
        dock.registerClass("BATTLESHIP", Battleship.class);
        dock.registerClass("DESTROYER", Destroyer.class);
        dock.registerClass("MINESWEEPER", Minesweeper.class);
        return dock;
    }

    @Test
    public void testShipConstructor() {
        Dock dock = this.getDock();
        try {
            Ship ship = dock.deploy("BATTLESHIP");
            assertTrue(ship != null);
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void testShipGetter(){
        Dock dock = this.getDock();
        try {
            Ship ship = dock.deploy("BATTLESHIP");
            assertNotNull(ship.getOccupiedSquares());
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
