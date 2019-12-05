package WorldObjects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;

public interface Movable extends IsWorldObject{
    RotationHandler getSteerer();
    MoveHandler getDriver();
}
