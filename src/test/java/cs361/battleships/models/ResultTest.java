package cs361.battleships.models;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResultTest {

    @Test
    public void testGetSetResult(){
        Result res = new Result();
        res.setResult(AtackStatus.HIT);
        AtackStatus ret = res.getResult();
        assertEquals(AtackStatus.HIT, ret);
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
        Ship test = new Ship("DESTROYER");
        res.setShip(test);
        Ship ret = res.getShip();
        assertEquals(test, ret);
    }
}
