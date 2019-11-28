package LableInterfaces;

import Fuctionality.IMotor;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IHasMotor {
     double getCurrentSpeed();
     double getEnginePower();
     void gas(double amount);
     void brake(double amount);
     IMotor getMotor();
    }

