package Fuctionality.MoveHandlers;

import java.awt.*;
import java.awt.geom.Point2D;

public interface MoveHandler {
    Point move(Point position, Point2D direction);
    double getCurrentSpeed();
    void setCurrentSpeed(double d);
    boolean isMoving();
    void setLocked(boolean locked);
}
