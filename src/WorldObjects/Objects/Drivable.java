package WorldObjects.Objects;

import Fuctionality.Colliders.StandardCollider;
import WorldObjects.InterfaceHierarchy.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Drivable extends WorldObject implements Movable {
    protected int turnAngle=90;

    protected Drivable(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position, direction, size, isStatic,new StandardCollider(false));
    }

    public void turnLeft(){ setDirection(getRotationHandler().turnLeft(turnAngle,getDirection())); }
    public void turnRight(){ setDirection(getRotationHandler().turnRight(turnAngle,getDirection())); }
    public void move(){ setPosition(getMoveHandler().move(getPosition(),getDirection(), getLoaded())); }
    public double getCurrentSpeed(){return getMoveHandler().getCurrentSpeed();}
    }

