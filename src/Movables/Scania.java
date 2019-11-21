package Movables; /** A scania truck*/
import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Truck {
    private String thisPicName="Scania";
    public Scania(Point position, Point2D direction) {
        super(position,direction);
        super.initialize(2,Color.WHITE,100,thisPicName,filePath+"/"+thisPicName+".jpg");
    }
    public Scania() {
        super();
        super.initialize(2,Color.WHITE,100,thisPicName,filePath+"/"+thisPicName+".jpg");
    }
}
