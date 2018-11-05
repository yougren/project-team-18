package cs361.battleships.models;

import org.junit.Test;

public class DockTest {

    @Test
    public void testDeReRegesterShip() {
        Dock dock = new Dock();
        dock.registerClass("BATTLESHIP", Battleship.class);
        dock.deregisterClass("BATTLESHIP");
    }
}
