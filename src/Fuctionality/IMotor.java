package Fuctionality;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IMotor {
    double getPower();
    double SpeedFactor();

    /** apply gas
     * @param amount how much to gas*/
    void gas(double amount);

    /** apply brake
     * @param amount how much to brake*/
     void brake(double amount);

     MoveHandler getMoveHandler();
}