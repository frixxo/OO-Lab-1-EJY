package WorldObjects.Objects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Drivable extends WorldObject implements Movable {
    private int turnAngle=90;

    protected Drivable(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position, direction, size, isStatic);
    }

    public void turnLeft(){ setDirection(getSteerer().turnLeft(turnAngle,getDirection())); }
    public void turnRight(){ setDirection(getSteerer().turnRight(turnAngle,getDirection())); }
    public void move(){ setPosition(getDriver().move(getPosition(),getDirection(),getStatic())); }
    public double getCurrentSpeed(){return getDriver().getCurrentSpeed();}
}
