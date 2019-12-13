package WorldObjects.LableInterfaces;

import WorldObjects.InterfaceHierarchy.WorldObjectH;

import java.awt.*;
import java.awt.geom.Point2D;

public interface WorldObjectView {

    WorldObjectH getObjectType();
    Point getPosition();
    Point2D getDirection();
    Point getSize();
    boolean getLocked();
    void UpdateCollider(Point Worldsize);
    String getType();
}
