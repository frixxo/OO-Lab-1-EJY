package Fuctionality.RotationHandler;

import WorldObjects.Objects.WorldObject;

import java.awt.geom.Point2D;

public interface RotationHandler {
    Point2D turnLeft(int angle, Point2D direction);
    Point2D turnRight(int angle, Point2D direction);
    int getTurnAngle();
    void setTurnAngle(int angel);
}