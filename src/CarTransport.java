import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck implements IHandleLast{
    private boolean ramp = false;
    private Stack<Car> car;
    private final byte MAX_CAR_LOADED = 5;
    private final byte MAX_LOAD_DISTANCE = 10;

    public byte getMaxCarLoaded() { return MAX_CAR_LOADED; }
    public byte getMaxLoadDistance() { return MAXIMUM_LOAD_DISTANCE; }

    @Override
    public void load(Car car) throws Exception {
        if (ramp && this.car.size() < MAX_CAR_LOADED && isCarBehind(car)) {
            this.car.push(car);
            return;
        } throw new Exception("Cannot load the car!");
    }

    @Override
    public Car release() throws Exception {
        if (ramp){
            Car car = this.car.pop();
            car.position.setLocation((int)(this.position.x + -10 * this.direction.x),
                    (int)(this.position.y + -10 * this.direction.y));
            return car;
        } throw new Exception("Ramp not lowered!");
    }

    public boolean lowerRamp(){
        ramp = !isMoving();
        return ramp;
    }

    private boolean isCarBehind(Car car){
        int dX = (int)(this.position.x + -MAX_LOAD_DISTANCE * this.direction.x);
        int dY = (int)(this.position.y + -MAX_LOAD_DISTANCE * this.direction.y);

        Rectangle rec = new Rectangle(dX-10, dY-10, dX+10, dY+10);
        return rec.contains(car.getPosition());
    }
}
