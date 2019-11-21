package Movables;
import LastHandle.*;

/** A car transporting truck for delivering cars*/
public class CarTransport extends Truck{
    private LoadHandler<Car> load;

    public CarTransport(){
        load = new LoadHandler<>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
        super.setTippingAmount(super.getMAX_ANGLE());
    }
    @Override
    public boolean lowerRamp(){
        load.setDock(false);
        return super.lowerRamp();
    }
    @Override
    public boolean raiseRamp(){
        load.setDock(true);
        return super.raiseRamp();
    }

    public boolean load(Car car) { return load.load(car);}
    public Car release() { return load.release(); }
    public int getCarsLoaded(){ return load.getCargoCount(); }

}
