package Fuctionality.RotationHandler;

import WorldObjects.Objects.WorldObject;

import java.awt.geom.Point2D;

public interface RotationHandler {
    void turnLeft(int angle, Point2D direction);
    void turnRight(int angle, Point2D direction);
}