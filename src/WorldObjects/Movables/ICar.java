package WorldObjects.Movables;

import Fuctionality.IMotor;
import LableInterfaces.IHasMotor;
import WorldObjects.Movables.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Defines what a car needs to do
 */

public interface ICar<T extends IMotor>{
    void initialize(int doors,Color color,String modelName,T motor);
    T getMotor();
}
