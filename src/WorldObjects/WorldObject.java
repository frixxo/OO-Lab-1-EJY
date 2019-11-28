package WorldObjects;

import java.awt.*;
import java.awt.geom.Point2D;

public interface WorldObject {
    Point getPosition();
    Point2D getRotation();
    Rectangle getSize();
}
