package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.TrimmedMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 implements ICar<TrimmedMotor> {
    private double trimFactor = 1.25;
    public final IMotor motor;
    private int NrDoors;
    private Color color;
    private String modelName;

    //region constructors
    public Volvo240(Point position,Point2D direction){

        initialize(4,Color.black,"Volvo240",new TrimmedMotor(100,1.25));
    }
    public Volvo240(){
        super();
        initialize(4,Color.black,"Volvo240",new TrimmedMotor(100,1.25));
    }
    //endregion

    @Override
    public void initialize(int doors, Color color, String modelName, IMotor motor) {
        this.NrDoors=doors;
        this.color=color;
        this.modelName=modelName;
        this.motor=motor;
    }

    @Override
    public IMotor getMotor() {
        return motor;
    }
}
