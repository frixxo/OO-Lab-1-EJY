package WorldObjects.Movables;

import java.awt.*;
import java.awt.geom.Point2D;
import WorldObjects.WorldObject;

/**
 * All movable objects implements this
 * and are supposted to move and turn
 * left or right.
 */
public interface Movable extends WorldObject{
    boolean IsLoaded=false;
    void move();
    void turnLeft();
    void turnRight();
    Point2D getDirection();
    boolean getIsLoaded();
    void setIsLoaded(boolean b);
}
