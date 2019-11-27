package LableInterfaces;

import java.awt.*;

import Flak.*;
import Fuctionality.NormalMotor;
import WorldObjects.Movables.Movable;

/**
 * Defines what a truck needs to do
 */

public interface Truck extends IHasFlak,IHasMotor, Movable {
    NormalMotor motor=new NormalMotor();
    IFlak flak = null;
    void initialize(int doors,Color color, int enginePower,String modelName);
    public String getRegNr();
    public int getNrDoors();
}

