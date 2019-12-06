package WorldObjects.InterfaceHierarchy;

import Systems.CollisionHandler;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IsWorldObject {
    boolean getStatic();
    void setStatic(boolean set);
    Point getPosition();
    Point2D getDirection();
    Point getSize();
    void updateCollider(Point Worldsize);
}
