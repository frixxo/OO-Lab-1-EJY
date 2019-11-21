package Movables;

import java.awt.*;
import java.awt.geom.Point2D;
import Flak.*;

/** Represents all things common for trucks*/
public abstract class Truck extends LandVehicle{

    public Truck(Point position, Point2D direction) {
        super(position,direction);
    }
    public Truck() {
        super();
    }

    @Override
    public double speedFactor(){ return enginePower*0.01; }

    @Override
    public void move(){ if (getFlak().normalState()) super.move(); }

    public boolean raiseRamp () {
        if (isMoving()) return false;
        return getFlak().raiseRamp();
    }

    public boolean lowerRamp () {
        if(isMoving()) return false;
        return getFlak().lowerRamp();
    }

    abstract IFlak getFlak();
}

