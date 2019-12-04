package WorldObjects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;

public interface Movable extends IsWorldObject{
    void turnLeft();
    void turnRight();
    void move();
    double getCurrentSpeed();
}
