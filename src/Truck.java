import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends LandVehicle{
    double TippingAngle=0;  //0 is when the truckbed is flat against the truck.
    double TippingAmount=5;
    public Truck(Point position, Point2D direction) {
        super(position,direction);
    }

    public Truck() {
        super();
    }

    public void lowerTruckbed(){
        increaseTippingAngle(-TippingAmount);
    }
    public void raiseTruckbed(){
        increaseTippingAngle(TippingAmount);
    }

    private void increaseTippingAngle(double amount){
        if(!(getCurrentSpeed()==0))return;
        TippingAngle=(TippingAngle+amount>70)?70:(TippingAngle+amount<0)?0:TippingAngle+amount;
    }
    @Override /** Truck is not supposed to move while truckbed is raised*/
    public void move(){
        if(isMoving())super.move();
    }
}

