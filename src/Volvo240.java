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
        initialize();
    }
    public Volvo240(){
        super();
        initialize();
    }
    /** has all common initializes for constructors*/
    private void initialize(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
    }
    //endregion
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
