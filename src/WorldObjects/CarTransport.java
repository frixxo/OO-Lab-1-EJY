package WorldObjects;
import Fuctionality.MoveHandler;
import Fuctionality.RegNrGenerator;
import LableInterfaces.IHasLast;
import LastHandle.*;
import Flak.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/
public class CarTransport extends WorldObject implements IHasLast<Car>, Truk {
    private LoadHandler<Car> load;
    private MoveHandler driver
    private RegNrGenerator reg= new RegNrGenerator();
    private String RegNr;
    private String ModelName="CarTransport";

    public CarTransport(){
        this();
    }
    public CarTransport(Point position, Point2D direction,Point Size){
        super(position,direction,Size,false);
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);

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
