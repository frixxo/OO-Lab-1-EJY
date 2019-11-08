import java.util.HashMap;
import java.util.Map;

public class Bilverkstad <T> {
    Map<String, T> cars = new HashMap<String, T>();

    public void add(T car){
        cars.put(((LandVehicle)car).getRegNr(), car);
    }

    /** How to remove a car from the bilverkstad
     * @param 
     * */
    public T get (String reg) {

        if(cars.containsKey(reg)) {
            return cars.get(reg);
        }
        else {
            throw new ClassCastException("No car with reg nr "+reg+" in this bilverkstad");
        }
    }
}
