package Movables; /** A scania truck*/
import Flak.Flak;
import Flak.IFlak;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {

    protected IFlak  flak = new Flak();
    public Scania(Point position, Point2D direction) {
        super(position,direction);
    }
    public Scania() {
        super();
    }

    @Override
    public double speedFactor(){ return enginePower*0.01;}

    protected IFlak getFlak (){return flak;}
}
