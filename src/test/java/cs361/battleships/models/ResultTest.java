package cs361.battleships.models;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResultTest {

    @Test
    public void testGetSetResult(){
        Result res = new Result();
        res.setResult(AttackStatus.HIT);
        AttackStatus ret = res.getResult();
        assertEquals(AttackStatus.HIT, ret);
    }

    @Test
    public void testGetSetLocation(){
        Result res = new Result();
        Square test = new Square(1, 'A');
        res.setLocation(test);
        Square ret = res.getLocation();
        assertEquals(test, ret);
    }

    @Test
    public void testGetSetShip() {
        Result res = new Result();
        Dock dock = new Dock();
        dock.registerClass("BATTLESHIP", Battleship.class);
        try {
            Ship test = dock.deploy("BATTLESHIP");
            res.setShip(test);
            Ship ret = res.getShip();
            assertEquals(test, ret);
        } catch (Exception e) {
            assertEquals(true, false);
        }
    }
}
