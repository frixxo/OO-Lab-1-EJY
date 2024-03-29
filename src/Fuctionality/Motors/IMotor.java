package Fuctionality.Motors;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IMotor {
    double getPower();
    double SpeedFactor();
    void startEngine();
    void stopEngine();

    /** apply gas
     * @param amount how much to gas*/
    void gas(double amount);

    /** apply brake
     * @param amount how much to brake*/
     void brake(double amount);

}