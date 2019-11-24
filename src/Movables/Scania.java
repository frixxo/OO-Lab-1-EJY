package Movables; /** A scania truck*/
import Flak.Flak;
import Flak.IFlak;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {

    public Scania(Point position, Point2D direction) {
        super(position,direction);
        super.initialize(2,Color.WHITE,100,"Scania",null);
        flak = new Flak();
    }
    public Scania() {
        super();
        super.initialize(2,Color.WHITE,100,"Scania",null);
        flak = new Flak();
    }

    @Override
    public double speedFactor(){ return enginePower*0.01;}
}
