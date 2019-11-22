package Movables;
import Flak.Ramp;
import Flak.IFlak;
import LastHandle.*;

import java.awt.*;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends Vehicle implements IHasLast<LandVehicle>{
    public IHandleLast<LandVehicle> load;
    private IFlak flak = new Ramp();

    public CarFerry(){
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }

    public boolean lowerRamp(){
        if(!isMoving()) {
            flak.lowerRamp();
            return true;
        } return false;
    }
    public void raiseRamp(){
        flak.raiseRamp();
    }

    public int getCarsLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (flak.normalState()) super.move();
        load.updatePosition(position);
    }

    @Override
    public boolean loadState() {
        return flak.loadState();
    }

    @Override
    public void IsLoadedMove(Point p) {
        load.updatePosition(p);
    }

    @Override
    public boolean load(LandVehicle landVehicle) {
        if(loadState()) return load.load(landVehicle);
        else return false;
    }

    @Override
    public LandVehicle release() {
        if(loadState())return load.release();
        else return null;
    }
}
