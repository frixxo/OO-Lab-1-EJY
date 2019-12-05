package WorldObjects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;

public interface Movable extends IsWorldObject{
    RotationHandler getRotationHandler();
    MoveHandler getMoveHandler();
}
