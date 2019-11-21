package Movables;
import LastHandle.*;
import Flak.*;

/** A car transporting truck for delivering cars*/
public class CarTransport extends Truck implements IHasLast<Car> {
    private LoadHandler<Car> load;
    private IFlak flak = new Ramp();

    public CarTransport(){
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
    }

    @Override
    public double speedFactor(){ return enginePower*0.01*(1-(getCarsLoaded()/100));}

    @Override
    public boolean lowerRamp(){
        return super.lowerRamp();
    }
    @Override
    public boolean raiseRamp(){
        return super.raiseRamp();
    }

    public boolean load(Car car) {
        if(loadState())return load.load(car);
        else return false;
    }
    public Car release() {
        if(loadState())return load.release();
        else return null;
    }

    @Override
    public boolean loadState() {
        return flak.loadState();
    }

    public int getCarsLoaded(){ return load.getCargoCount(); }

    protected IFlak getFlak (){return flak;}

}
