package Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends Car{
    private String thisPicName="Volvo240";
    public final static double trimFactor = 1.25;
    //region constructors
    public Volvo240(Point position,Point2D direction){
        super(position,direction);
        initialize(4,Color.black,100,thisPicName,filePath+"/"+thisPicName+".jpg");
    }
    public Volvo240(){
        super();
        initialize(4,Color.black,100,thisPicName,filePath+"/"+thisPicName+".jpg");
    }
    //endregion
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
