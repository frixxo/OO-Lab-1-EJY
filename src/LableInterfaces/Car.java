package LableInterfaces;

import Fuctionality.IMotor;
import Fuctionality.NormalMotor;
import WorldObjects.Movables.Movable;

import java.awt.*;

/**
 * Defines what a car needs to do
 */

public interface Car extends IHasMotor, Movable {
    IMotor motor=null;
    void initialize(int doors,Color color, int enginePower,String modelName,IMotor motor);
    String getRegNr();
    int getNrDoors();
}
