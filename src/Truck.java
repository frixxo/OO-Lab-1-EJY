import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends LandVehicle{
    private double angle = 0;  //0 is when the ramp is flat against the truck.
    private double tippingAmount = 5;
    private final double MAX_ANGLE = 70;

    public Truck(Point position, Point2D direction) {
        super(position,direction);
    }
    public Truck() {
        super();
    }

    public boolean lowerRamp(){
        return increaseTippingAngle(-tippingAmount);
    }
    public void raiseRamp(){
        increaseTippingAngle(tippingAmount);
    }

    private boolean increaseTippingAngle(double amount){
        if(isMoving()) return false;
        angle=(angle+amount > MAX_ANGLE) ? MAX_ANGLE : (angle+amount < 0) ? 0 : angle+amount;
        return true;
    }

    @Override
    public void move(){ if (angle == 0) super.move(); }
}

