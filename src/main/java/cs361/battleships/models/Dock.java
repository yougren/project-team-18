package cs361.battleships.models;

import javax.validation.constraints.Null;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Dock {

    private Map<String, Class<? extends Ship>> type;

    public Dock() {
        this.type = new HashMap<>();
    }

    public Ship deploy(String ship) throws InstantiationException {
        try {
            return type.get(ship.toUpperCase()).getConstructor().newInstance();
        } catch (InstantiationException e) {
            System.err.println("Error instantiating ship type class.");
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor for ship type class not found while attempting to instantiate." + e);
        } catch (InvocationTargetException e) {
            System.err.println("Invocation Target Exception while attempting to instantiate ship type class." + e);
        } catch (IllegalAccessException e) {
            System.err.println("Invocation Target Exception while attempting to instantiate ship type class." + e);
        }
        throw new InstantiationException("Could not instance ship type.");
    }

    public void registerClass(String key, Class<? extends Ship> sc) {
       this.type.put(key.toUpperCase(), sc);
    }

    public void deregisterClass(String key) {
        this.type.remove(key.toUpperCase());
    }
}
