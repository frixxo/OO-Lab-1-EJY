import java.awt.*;

public class CarTransport extends Truck{
    private LoadHandler load;

    public CarTransport(){
        load = new LoadHandler(this, 5, 10, LoadHandler.Principle.FILO);
    }

    public boolean lowerRamp(){ return load.lowerRamp(); }
    public void load(Car car) throws Exception { load.load(car); }
    public Car release() throws Exception { return load.release(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (load.getRamp()) super.move();
    }

}
