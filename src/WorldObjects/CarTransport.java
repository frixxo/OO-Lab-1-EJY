package WorldObjects;
import LableInterfaces.IHasLast;
import LastHandle.*;
import Flak.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/
public class CarTransport extends WorldObject implements IHasLast<Car>, Truk {
    private LoadHandler<Car> load;

    public CarTransport(){
        super();
        super.initialize(2,Color.black,100,"CarTransport");
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
        flak=new Ramp();
    }
    public CarTransport(Point position, Point2D direction){
        super(position,direction);
        super.initialize(2,Color.black,100,"CarTransport");
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
        flak=new Ramp();
    }

    @Override
    public double speedFactor(){ return enginePower*0.01*(1-(getCarsLoaded()/100));}

    public boolean load(Car car) {
        if(loadState())return load.load(car);
        else return false;
    }
    public Car release() {
        if(loadState())return load.release();
        else return null;
    }

    @Override
    public void move(){
        if(flak.normalState()) super.move();
        load.updatePosition(this.position);
    }

    @Override
    public boolean loadState() {
        return flak.loadState();
    }

    @Override
    public void IsLoadedMove(Point p) {
        load.updatePosition(p);
    }

    public int getCarsLoaded(){ return load.getCargoCount(); }

}
