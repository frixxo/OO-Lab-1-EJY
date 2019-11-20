package Movables; /** A scania truck*/
import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {
    public Scania(Point position, Point2D direction) {
        super(position,direction);
        initialize(2,Color.WHITE,100,"Scania", "pics/Scania.jpg");
    }
    public Scania() {
        super();
        initialize(2,Color.WHITE,100,"Scania", "pics/Scania.jpg");
    }
}
