package WorldObjects;

import Fuctionality.DriveHandler;
import Fuctionality.SteerHandler;

public interface Movable {
    DriveHandler getDriveHandler();
    SteerHandler getSteerHandler();
}
