package Movables; /** A scania truck*/
import Flak.Flak;
import Flak.IFlak;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {

    protected IFlak  flak = new Flak();
    public Scania(Point position, Point2D direction) {
        super(position,direction);
        super.initialize(2,Color.WHITE,100,"Scania");
    }
    public Scania() {
        super();
        super.initialize(2,Color.WHITE,100,"Scania");
    }

    @Override
    public double speedFactor(){ return enginePower*0.01;}

    protected IFlak getFlak (){return flak;}
}
