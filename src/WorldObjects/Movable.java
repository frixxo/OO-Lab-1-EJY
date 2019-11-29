package WorldObjects;

import Fuctionality.MoveHandler;

public interface Movable {
    MoveHandler getDriveHandler();
    RotationHandler getSteerHandler();

    interface RotationHandler {
        void turnLeft(int angle);
        void turnRight(int angle);
    }
}
