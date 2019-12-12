package WorldObjects.Objects;

import Fuctionality.Colliders.StandardCollider;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.InterfaceHierarchy.IsWorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Drivable extends WorldObject implements IsWorldObject {

    RotationHandler rotationHandler;
    MoveHandler moveHandler;

    protected Drivable(Point position, Point2D direction, Point size, boolean isStatic, RotationHandler rotationHandler, MoveHandler moveHandler,String type) {
        super(position, direction, size, isStatic,new StandardCollider(false),type);
        this.moveHandler = moveHandler;
        this.rotationHandler = rotationHandler;
    }

    public void turnLeft(){ setDirection(getRotationHandler().turnLeft(getRotationHandler().getTurnAngle(),getDirection())); }
    public void turnRight(){ setDirection(getRotationHandler().turnRight(getRotationHandler().getTurnAngle(),getDirection())); }
    public void move(){ setPosition(getMoveHandler().move(getPosition(),getDirection())); }
    public double getCurrentSpeed(){return getMoveHandler().getCurrentSpeed();}

    protected RotationHandler getRotationHandler() {return  rotationHandler;}
    protected MoveHandler getMoveHandler() {
        moveHandler.setLocked(getLocked());
        return  moveHandler;
    }
}