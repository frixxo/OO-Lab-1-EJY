package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.MoveHandler;

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
