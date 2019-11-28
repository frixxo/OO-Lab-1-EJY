package Fuctionality;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IMotor {
    double getCurrentSpeed();
    double getPower();
    void startEngine();
    void stopEngine();

    double SpeedFactor();

    /** apply gas
     * @param amount how much to gas*/
    void gas(double amount);

    /** apply brake
     * @param amount how much to brake*/
     void brake(double amount);

    /** checks if the vehicle is moving
     * @return if the vehicle is moving*/
     boolean isMoving();

    /** move car ahead
     * @param position the vehicles position
     * @param direction the vehicles direction
     * @param IsLoaded if the vehicle is loaded*/
     void move(Point position, Point2D direction, boolean IsLoaded);
}