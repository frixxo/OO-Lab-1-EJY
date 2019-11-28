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

    void move();
    //TODO implement rotate() and remove turnLeft(), turnRight()
    void turnLeft();
    void turnRight();
    //void rotate();
    Point2D getDirection();
    boolean getIsLoaded();
    void setIsLoaded(boolean isLoaded);
    int getSpeed();
    void setSpeed(int speed);
    void setPosition(Point position);
    void setRotation(Point2D rotation);
    /** makes sure the cars picture does not move out of frame
     * @param windowsize the size of the operating window
     * @param picsize the size of the cars picture*/
    void fixPosition(Point windowsize,Point picsize);
}
