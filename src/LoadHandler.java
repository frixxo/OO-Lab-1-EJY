import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class LoadHandler {
    Deque<Car> carList;
    Vehicle transport;
    private final int MAX_CAR_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private boolean ramp;

    public LoadHandler(Vehicle transport, int maxCarLoad, int maxLoadDistance){
        carList = new LinkedList<>();
        ramp = false;
        MAX_CAR_LOAD = maxCarLoad;
        MAX_LOAD_DISTANCE = maxLoadDistance;
        this.transport = transport;
    }


    public void load(Car car) throws Exception {
        if (ramp && carList.size() < MAX_CAR_LOAD && isCarBehind(car)) {
            carList.push(car);
            return;
        } throw new Exception("Cannot load the car!");
    }

    public Car release() throws Exception {
        if (ramp){
            Car car = this.car.pop();
            car.position.setLocation((int)(transport.position.x + -10 * transport.direction.getX()),
                    (int)(transport.position.y + -10 * transport.direction.getY()));
            return car;
        } throw new Exception("Ramp not lowered!");
    }

    private boolean isCarBehind(Car car){
        int dX = (int)(transport.position.x + -MAX_LOAD_DISTANCE * transport.direction.getX());
        int dY = (int)(transport.position.y + -MAX_LOAD_DISTANCE * transport.direction.getY());

        Rectangle rec = new Rectangle(dX-10, dY-10, dX+10, dY+10);
        return rec.contains(car.getPosition());
    }
}
