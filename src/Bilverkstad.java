import Movables.LandVehicle;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
/** A representation of a car repairshop where you */
public class Bilverkstad<T  extends  LandVehicle> {
    private Map<String, T> cars = new HashMap<String, T>();
    private Point location;
    private int maxCars = 0;;
    private final int distToCArDeadzone = 3;


    public boolean add(T car){

        if (cars.size() == maxCars || location.distance(car.getPosition()) > distToCArDeadzone
                || location.distance(car.getPosition()) > distToCArDeadzone||car.getIsLoaded()) return false;
        cars.put (car.getRegNr(), car);
        car.setIsLoaded(true);
        return true;
    }

    /** How to remove a car from the bilverkstad
     * @param reg reg nr for the sought after car
     * @return the sought car
     * */
    public T get (String reg) {

        if(cars.containsKey(reg)) {
            cars.get(reg).setIsLoaded(false);
            return cars.get(reg);
        }
        else {
            throw new ClassCastException("No car with reg nr "+reg+" in this bilverkstad");
        }
    }

    public Bilverkstad(Point location, int maxCars){
        this.location=location;
        this.maxCars = maxCars;
    }

    public Point getLocation() {
        return location;
    }

    public int getMaxCars() {
        return maxCars;
    }
    public int numberOfCars() {
        return cars.size();
    }
}
