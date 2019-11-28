package LableInterfaces;

import Fuctionality.IMotor;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IHasMotor {
     double getCurrentSpeed();
     double getEnginePower();
     void startEngine();
     void stopEngine();
     void gas(double amount);
     void brake(double amount);
     void move(Point position,Point2D direction,boolean IsLoaded);
     IMotor getMotor();
    }

