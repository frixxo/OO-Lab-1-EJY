package Movables;
import LastHandle.*;
import Flak.*;

/** A car transporting truck for delivering cars*/
public class CarTransport extends Truck{
    private LoadHandler<Car> load;

    private IFlak flak = new Flak2();

    public CarTransport(){
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
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
    public Car release() { return (Car)load.release(); }
    public int getCarsLoaded(){ return load.getCargoCount(); }

    protected IFlak getFlak (){return flak;}

}
