import java.awt.*;

public class CarTransport extends Truck{
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
    private boolean ramp = false;
   // private Stack<Car> car = new Stack<>();
    private final byte MAX_CAR_LOADED = 5;
    private final byte MAX_LOAD_DISTANCE = 10;

    public byte getMaxCarLoaded() { return MAX_CAR_LOADED; }
    public byte getMaxLoadDistance() { return MAX_LOAD_DISTANCE; }

    public IHandleLast<Car> lastHandler = new LoadHandlerStack<Car>(this,MAX_CAR_LOADED, MAX_LOAD_DISTANCE);

    /*
    public void load(Car car) throws Exception {
        if (ramp && this.car.size() < MAX_CAR_LOADED && isCarBehind(car)) {
            this.car.push(car);
            return;
        } throw new Exception("Cannot load the car!");
    }

    public Car release() throws Exception {
        if (ramp){
            Car car = this.car.pop();
            car.position.setLocation((int)(this.position.x + -10 * this.direction.getX()),
                    (int)(this.position.y + -10 * this.direction.getY()));
            return car;
        } throw new Exception("Ramp not lowered!");
    }
*/
<<<<<<< Updated upstream
=======
=======
    private LoadHandler load;

    public CarTransport(){
        load = new LoadHandler(this, 5, 10, LoadHandler.Principle.FILO);
    }

    public boolean lowerRamp(){ return load.lowerRamp(); }
    public void load(Car car) throws Exception { load.load(car); }
    public Car release() throws Exception { return load.release(); }

>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (load.getRamp()) super.move();
    }

}
