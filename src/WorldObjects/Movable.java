package WorldObjects;

import Fuctionality.MoveHandler;
import Fuctionality.RotationHandler;

public interface Movable {
    MoveHandler getDriveHandler();
    RotationHandler getSteerHandler();
}
