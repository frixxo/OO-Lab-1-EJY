package WorldObjects;

import Fuctionality.MoveHandler;

public interface Movable extends IsWorldObject{
    MoveHandler getDriveHandler();
    RotationHandler getSteerHandler();

    interface RotationHandler {
        void turnLeft(int angle);
        void turnRight(int angle);
    }
}
