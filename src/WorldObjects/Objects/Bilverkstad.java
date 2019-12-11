package WorldObjects.Objects;

import Fuctionality.Colliders.StandardCollider;
import WorldObjects.InterfaceHierarchy.IsWorldObject;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
/** A representation of a car repairshop where you */
public class Bilverkstad<T extends Vehicle> extends WorldObject implements IsWorldObject{
    private Map<String, T> cars = new HashMap<String, T>();
    private int maxCars = 0;
    private final int distToCArDeadzone = 3;


    public boolean add(T car){
        if ((numberOfCars() == getMaxCars() || getPosition().distance(car.getPosition()) > distToCArDeadzone)
                || getPosition().distance(car.getPosition()) > distToCArDeadzone|| car.getLocked()) return false;
        cars.put (car.getID(), car);
        car.setLocked(true);
        return true;
    }

    /** How to remove a car from the bilverkstad
     * @param reg reg nr for the sought after car
     * @return the sought car
     * */
    public T get (String reg) {

        if(cars.containsKey(reg)) {
            cars.get(reg).setLocked(false);
            return cars.get(reg);
        }
        else {
            throw new ClassCastException("No car with reg nr "+reg+" in this bilverkstad");
        }
    }

    public Bilverkstad(Point location, int maxCars){
        super(location,new Point(0, 0),new Point(200,200),false,new StandardCollider(false));
        this.maxCars = maxCars;
    }

    public int getMaxCars() {
        return maxCars;
    }
    public int numberOfCars() {
        return cars.size();
    }

    @Override
    public boolean getLocked() {
        return false;
    }
}
