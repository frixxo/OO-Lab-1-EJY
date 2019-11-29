package WorldObjects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.RotationHandler;
import LableInterfaces.IHasMotor;

/**
 * Defines what a car needs to do
 */

public interface Car extends IHasMotor {

    IMotor getMotor();
}
