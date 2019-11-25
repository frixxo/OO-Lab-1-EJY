package WorldObjects.Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/** Defines which vehicles that are normal cars*/
public abstract class Car extends LandVehicle {
    public Car(Point position, Point2D direction) {
        super(position,direction);
    }

    public Car() {
        super();
    }


}
