package Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends Car{
    public final static double trimFactor = 1.25;

    //region constructors
    public Volvo240(Point position,Point2D direction){
        super(position,direction);
        initialize(4,Color.black,100,"Volvo240",null);

    }
    public Volvo240(){
        super();
        initialize(4,Color.black,100,"Volvo240",null);
    }
    //endregion
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
