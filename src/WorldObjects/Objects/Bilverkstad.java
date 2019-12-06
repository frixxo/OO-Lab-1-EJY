package WorldObjects.Objects;

import Fuctionality.Colliders.IStaticCollider;
import Fuctionality.Colliders.ObjectCollider;
import Fuctionality.Colliders.VehicleCollider;
import WorldObjects.InterfaceHierarchy.Vehicle;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
/** A representation of a car repairshop where you */
public class Bilverkstad<T extends WorldObject & Vehicle> extends WorldObject {
    private Map<String, T> cars = new HashMap<String, T>();
    private int maxCars = 0;
    private final int distToCArDeadzone = 3;


    public boolean add(T car){
        if ((numberOfCars() == getMaxCars() || getPosition().distance(car.getPosition()) > distToCArDeadzone)
                || getPosition().distance(car.getPosition()) > distToCArDeadzone|| car.getStatic()) return false;
        cars.put (car.getRegNr(), car);
        car.setStatic(true);
        return true;
    }

    /** How to remove a car from the bilverkstad
     * @param reg reg nr for the sought after car
     * @return the sought car
     * */
    public T get (String reg) {

        if(cars.containsKey(reg)) {
            cars.get(reg).setStatic(false);
            return cars.get(reg);
        }
        else {
            throw new ClassCastException("No car with reg nr "+reg+" in this bilverkstad");
        }
    }

    public Bilverkstad(Point location, int maxCars){
        super(location,null,new Point(200,200),true,new ObjectCollider());
        this.maxCars = maxCars;
    }

    public int getMaxCars() {
        return maxCars;
    }
    public int numberOfCars() {
        return cars.size();
    }

}
