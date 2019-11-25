package WorldObjects.Movables;

import java.awt.*;
import java.awt.geom.Point2D;
import Flak.*;

/** Represents all things common for trucks*/
public abstract class Truck extends LandVehicle implements IHasFlak {
    protected IFlak flak = null;
    public Truck(Point position, Point2D direction) {
        super(position,direction);
    }
    public Truck() {
        super();
    }

    @Override
    public void move(){ if (getFlak().normalState()) super.move(); }

    public boolean raiseFlak () {
        if (isMoving()) return false;
        return getFlak().raiseRamp();
    }

    public boolean lowerFlak () {
        if(isMoving()) return false;
        return getFlak().lowerRamp();
    }

    public IFlak getFlak(){return flak;}
}

