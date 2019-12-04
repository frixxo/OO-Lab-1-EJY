package Fuctionality.MoveHandlers;

import java.awt.*;
import java.awt.geom.Point2D;

public interface MoveHandler {
    Point move(Point position, Point2D direction, boolean Static);
    double getCurrentSpeed();
    void setCurrentSpeed(double d);
}
