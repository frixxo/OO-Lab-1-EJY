package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.MotorHandler;
import LableInterfaces.IHasMotor;
import WorldObjects.Movables.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Defines what a car needs to do
 */

public interface ICar{
    MotorHandler motorhandler=new MotorHandler();
    void initialize(int doors,Color color,String modelName,IMotor motor);
    IMotor getMotor();
}
