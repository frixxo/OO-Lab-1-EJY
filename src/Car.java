import java.awt.*;
import java.awt.geom.Point2D;

/** Definerar vilka fordon som är vanliga bilar*/
public abstract class Car extends LandVehicle {
    public Car(Point position, Point2D direction) {
        super(position,direction);
    }

    public Car() {
        super();
    }
}
