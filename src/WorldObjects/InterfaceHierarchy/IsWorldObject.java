package WorldObjects.InterfaceHierarchy;

import Fuctionality.Colliders.Collider;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IsWorldObject {
    boolean getLoaded();
    void setLoaded(boolean set);
    Point getPosition();
    Point2D getDirection();
    Point getSize();
    Collider getCollider();
    void setPosition(Point Position);
    void setDirection(Point2D direction);
}
