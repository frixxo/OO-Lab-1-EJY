package Fuctionality.RotationHandler;

import java.awt.geom.Point2D;

public class VehicleSteerer implements RotationHandler {

    public Point2D turnLeft(int turnAngle, Point2D direction){ return rotate(360-turnAngle,direction); }
    public Point2D turnRight(int turnAngle, Point2D direction){ return rotate(turnAngle,direction); }

    /** calculates the rotation of the car when using turn methods (Origo is top left so we had to flip the rotation using -y)
     * @param angle how much to turn
     * */
    private Point2D rotate (double angle, Point2D direction)
    {
        angle = angle*(Math.PI/180);
        double x = direction.getX();
        double y = direction.getY();
        return (new Point2D.Double(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) + y*Math.cos(angle)));
    }
}
