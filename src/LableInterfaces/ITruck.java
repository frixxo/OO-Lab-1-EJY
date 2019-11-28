package LableInterfaces;

import java.awt.*;

import Flak.*;
import Fuctionality.IMotor;
import Fuctionality.NormalMotor;
import WorldObjects.Movables.Movable;

/**
 * Defines what a truck needs to do
 */

public interface ITruck extends IHasFlak,IHasMotor, Movable {
    IMotor motor=new ();
    IFlak flak = null;
    void initialize(int doors,Color color, int enginePower,String modelName);
    public String getRegNr();
    public int getNrDoors();
}

