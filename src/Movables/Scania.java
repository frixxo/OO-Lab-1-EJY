package Movables; /** A scania truck*/
import Flak.Flak1;
import Flak.IFlak;
import Flak.NormalFlak;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {

    protected IFlak  flak = new Flak1();
    public Scania(Point position, Point2D direction) {
        super(position,direction);
    }
    public Scania() {
        super();
    }

    protected IFlak getFlak (){return flak;}
}
