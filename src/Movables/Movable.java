package Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * All movable objects implements this
 * and are supposted to move and turn
 * left or right.
 */
public interface Movable {
    boolean IsLoaded=false;
    void move();
    void turnLeft();
    void turnRight();
    Point getPosition();
    Point2D getDirection();
    boolean getIsLoaded();
    void setIsLoaded(boolean b);
}
