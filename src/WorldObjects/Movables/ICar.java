package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.MoveHandler;
import LableInterfaces.IHasMotor;
import WorldObjects.Movables.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Defines what a car needs to do
 */

public interface ICar extends Movable{
    /** has all common variables for the constructors
     * @param   color the color the vehicle is supposed to have
     * @param   enginePower the enginepower the car is supposed to have
     * @param   modelname the model of the car
     * */
    IMotor getMotor();
    /** makes sure every car has an movehandler we can use*/
    MoveHandler getMoveHandler();
}
