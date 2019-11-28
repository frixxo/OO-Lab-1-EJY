package WorldObjects;

import java.awt.*;
import java.awt.geom.Point2D;

public interface WorldObjectView {

    Point getPosition();
    Point2D getDirection();
    Point getSize();
    boolean getStatic();
}
