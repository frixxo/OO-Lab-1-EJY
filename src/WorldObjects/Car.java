package WorldObjects;

import Fuctionality.*;

/**
 * Defines what a car needs to do
 */

public interface Car {

    IMotor getMotor();
    /** makes sure every car has an movehandler we can use*/
    DriveHandler getDriver();

    SteerHandler getSteerer();

}
