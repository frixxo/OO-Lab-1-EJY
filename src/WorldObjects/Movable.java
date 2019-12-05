package WorldObjects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import Systems.CollisionHandler;

public interface Movable extends IsWorldObject{
    RotationHandler getRotationHandler();
    MoveHandler getMoveHandler();
}
