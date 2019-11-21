package Movables;
import LastHandle.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/
public class CarTransport extends Truck{
    private LoadHandler<Car> load;
    private String thisPicName="Cartransport";

    public CarTransport(){
        super();
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
        super.setTippingAmount(super.getMAX_ANGLE());
        initialize(2, Color.blue,150,thisPicName,filePath+"/"+thisPicName+".jpeg");
    }
    public CarTransport(Point position, Point2D direction){
        super(position,direction);
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
        super.setTippingAmount(super.getMAX_ANGLE());
        initialize(2, Color.blue,150,thisPicName,filePath+"/"+thisPicName+".jpeg");
    }

    @Override
    public boolean lowerRamp(){
        load.setDock(false);
        return super.lowerRamp();
    }
    @Override
    public boolean raiseRamp(){
        load.setDock(true);
        return super.raiseRamp();
    }

    public boolean load(Car car) { return load.load(car);}
    public Car release() { return (Car)load.release(); }
    public int getCarsLoaded(){ return load.getCargoCount(); }

}
