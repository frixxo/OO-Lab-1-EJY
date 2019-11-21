package Movables;
import LastHandle.*;

/** A car transporting truck for delivering cars*/
public class CarTransport extends Truck{
    private IHandleLast load;

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

    public boolean load(Car car) {
        if(!getIsLoaded())return load.load(car);
        else return false;
    }
    public Car release() {
        if(!getIsLoaded())return (Car)load.release();
        else return null;
    }
    public int getCarsLoaded(){ return load.getCargoCount(); }
    @Override
    public void move(){
        if (!load.dockStatus()) super.move();
        load.updatePosition(position);
    }
}
