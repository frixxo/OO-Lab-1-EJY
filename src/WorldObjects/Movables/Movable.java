package WorldObjects.Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * All movable objects implements this
 * and are supposted to move and turn
 * left or right.
 */
public interface Movable extends WorldObject{
    void setPosition(Point position);
    void setDirection (Point2D direction);

    boolean getIsStatic();
    void setIsLStatic(boolean isLoaded);

    /** makes sure the cars picture does not move out of frame
     * @param windowsize the size of the operating window
     * @param picsize the size of the cars picture*/
}
