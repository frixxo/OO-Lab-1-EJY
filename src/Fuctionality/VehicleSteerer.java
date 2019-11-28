package Fuctionality;

import WorldObjects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class VehicleSteerer implements SteerHandler {
    private WorldObject worldObject;

    public VehicleSteerer(WorldObject worldObject){
        this.worldObject=worldObject;
    }

    public void turnLeft(int turnAngle){
        rotate(360-turnAngle);
    }
    public void turnRight(int turnAngle){
        rotate(turnAngle);
    }

    /** calculates the rotation of the car when using turn methods (Origo is top left so we had to flip the rotation using -y)
     * @param angle how much to turn
     * */
    private void rotate (double angle)
    {
        angle = angle*(Math.PI/180);
        double x = worldObject.getDirection().getX();
        double y = worldObject.getDirection().getY();
        worldObject.setDirection(new Point2D.Double(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) + y*Math.cos(angle)));
    }
}
