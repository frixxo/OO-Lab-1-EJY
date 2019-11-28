package WorldObjects.Movables;

import java.awt.*;

import Flak.*;
import Fuctionality.IMotor;
import LableInterfaces.IHasFlak;
import LableInterfaces.IHasMotor;

/**
 * Defines what a truck needs to do
 */

public abstract class Truck implements IHasFlak, IHasMotor, Movable {

    protected IFlak flak;
    protected IMotor engine;
    protected int NrDoors;
    protected Color color;
    protected String modelName;

    void initialize(int doors,Color color,String modelName,IMotor motor){
        this.engine=motor;
        this.NrDoors=doors;
        this.color=color;
        this.modelName=modelName;
    }

    public String getRegNr(){return modelName;}
    public int getNrDoors(){return NrDoors;}
}


