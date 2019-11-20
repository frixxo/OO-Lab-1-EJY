package Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * All movable objects implements this
 * and are supposted to move and turn
 * left or right.
 */
public interface Movable {
    void move();
    void turnLeft();
    void turnRight();
    Point getPosition();
    Point2D getDirection();
}