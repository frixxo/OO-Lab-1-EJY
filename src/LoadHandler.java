import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * simulates transportation vehicles for car
 * */
public class LoadHandler {
    public enum Principle{FIFO, FILO}

    Deque<Car> carList;
    Vehicle transport;
    private boolean ramp;

    private final int MAX_CAR_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private final Principle principle;

    public LoadHandler(Vehicle transport, int maxCarLoad, int maxLoadDistance, Principle principle){
        carList = new LinkedList<>();
        ramp = false;
        MAX_CAR_LOAD = maxCarLoad;
        MAX_LOAD_DISTANCE = maxLoadDistance;
        this.transport = transport;
        this.principle = principle;
    }

    public int getMaxCarLoaded() { return MAX_CAR_LOAD; }
    public int getMaxLoadDistance() { return MAX_LOAD_DISTANCE; }
    public boolean getRamp(){ return ramp; }


    public void load(Car car) throws Exception {
        if (ramp && carList.size() < MAX_CAR_LOAD && isCarBehind(car)) {
            carList.add(car);
            return;
        } throw new Exception("Cannot load the vehicle!");
    }


    public Car release() throws Exception {
        if (ramp){
            Car car;
            switch (principle){
                case FILO:
                    car = carList.pollLast();
                    break;
                case FIFO:
                    car = carList.pollFirst();
                    break;
                default:
                    car = null;
            }

            car.position.setLocation((int)(transport.position.x + -10 * transport.direction.getX()),
                    (int)(transport.position.y + -10 * transport.direction.getY()));
            return car;
        } throw new Exception("Ramp not lowered!");
    }

    public boolean lowerRamp(){
        ramp = !transport.isMoving();
        return ramp;
    }

    public void liftRamp(){ ramp = false; }

    private boolean isCarBehind(Car car){
        int dX = (int)(transport.position.x + -MAX_LOAD_DISTANCE * transport.direction.getX());
        int dY = (int)(transport.position.y + -MAX_LOAD_DISTANCE * transport.direction.getY());

        Rectangle rec = new Rectangle(dX-10, dY-10, dX+10, dY+10);
        return rec.contains(car.getPosition());
    }
}
