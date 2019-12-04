package Fuctionality.RotationHandler;

import WorldObjects.Movable;
import WorldObjects.Objects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class VehicleSteerer implements RotationHandler {

    public void turnLeft(int turnAngle, Point2D direction){ rotate(360-turnAngle,direction); }
    public void turnRight(int turnAngle, Point2D direction){ rotate(turnAngle,direction); }

    /** calculates the rotation of the car when using turn methods (Origo is top left so we had to flip the rotation using -y)
     * @param angle how much to turn
     * */
    private void rotate (double angle, Point2D direction)
    {
        angle = angle*(Math.PI/180);
        double x = direction.getX();
        double y = direction.getY();
        direction.setLocation (new Point2D.Double(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) + y*Math.cos(angle)));
    }
}
