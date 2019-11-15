import java.awt.*;
import java.awt.geom.Point2D;
/** Represents all things common for trucks*/
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
    public boolean raiseRamp(){
        return increaseTippingAngle(tippingAmount);
    }


    /** private method for raising or lowering the tipping angle called on by lower or raise ramp
     * @param amount how much to change the angle
     * @return if successful
     * */
    private boolean increaseTippingAngle(double amount){
        if(isMoving()) return false;
        angle=(angle+amount > MAX_ANGLE) ? MAX_ANGLE : (angle+amount < 0) ? 0 : angle+amount;
        return true;
    }

    @Override
    public double speedFactor(){ return enginePower*0.01; }

    @Override
    public void move(){ if (IsLowered()) super.move(); }

    public double getMAX_ANGLE() {
        return MAX_ANGLE;
    }

    public void setTippingAmount(double tippingAmount) {
        this.tippingAmount = tippingAmount;
    }

    public boolean IsLowered() {
        return angle==0;
    }
}

