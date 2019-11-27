package WorldObjects.Movables;
import LableInterfaces.IHasFlak;
import Flak.Ramp;
import Flak.IFlak;
import LableInterfaces.IHasLast;
import LastHandle.IHandleLast;
import LastHandle.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends Vehicle implements IHasLast<LandVehicle>, IHasFlak {
    public IHandleLast<LandVehicle> load;
    private IFlak flak = new Ramp();

    public CarFerry(){
        super();
        super.initialize(Color.YELLOW,100,"CarFerry");
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }
    public CarFerry(Point position, Point2D direction){
        super(position,direction);
        super.initialize(Color.yellow,100,"CarFerry");
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }
    public boolean lowerFlak(){
        if(!isMoving()) {
            flak.lowerRamp();
            return true;
        } return false;
    }

    @Override
    public IFlak getFlak() {
        return flak;
    }

    public boolean raiseFlak(){
        return flak.raiseRamp();
    }

    public int getCarsLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.009; }
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
