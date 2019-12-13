package WorldObjects.LableInterfaces;

import Fuctionality.Colliders.Collider;
import WorldObjects.InterfaceHierarchy.WorldObjectH;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IsWorldObject {
    boolean getLocked();
    void setLocked(boolean set);
    Point getPosition();
    Point2D getDirection();
    Point getSize();
    Collider getCollider();
    void setPosition(Point Position);
    void setDirection(Point2D direction);
    WorldObjectH getObjectType();
}
