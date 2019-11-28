package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.TrimmedMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 implements ICar {
    private double trimFactor = 1.25;
    private int NrDoors;
    private Color color;
    private String modelName;
    private IMotor motor=new TrimmedMotor(100,1.25);
    private MoveHandler movehandler;

    //region constructors
    public Volvo240(Point position,Point2D direction){
        movehandler=new MoveHandler(position,direction);
        initialize(4,Color.black,"Volvo240");
    }
    public Volvo240(){
        movehandler=new MoveHandler();
        initialize(4,Color.black,"Volvo240");
    }
    //endregion

    @Override
    public void initialize(int doors, Color color, String modelName) {
        this.NrDoors=doors;
        this.color=color;
        this.modelName=modelName;
        this.motor=motor;
    }

    @Override
    public IMotor getMotor() {
        return motor;
    }
    @Override
    public MoveHandler getMoveHandler() {
        return movehandler;
    }

}
