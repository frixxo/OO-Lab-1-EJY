package Movables;
import Flak.Flak2;
import Flak.IFlak;
import LastHandle.*;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends Vehicle{
    public IHandleLast load;
    private IFlak flak = new Flak2();

    public CarFerry(){
        load = new LoadHandler<LandVehicle>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }

    public boolean lowerRamp(){
        if(!isMoving()) {
            flak.lowerRamp();
            load.setDock(flak.loadState());
            return true;
        } return false;
    }
    public void raiseRamp(){
        flak.raiseRamp();
        load.setDock(flak.loadState());
    }

    public int getCarsLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (flak.normalState()) super.move();
        load.updatePosition(position);
    }
}
