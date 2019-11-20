package Movables;
import LastHandle.*;

import java.awt.*;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends Vehicle{
    public IHandleLast load;

    public CarFerry(){
        super();
        initialize(Color.red,200,"pics/Färja.jpeg");
        load = new LoadHandler<LandVehicle>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }

    public boolean lowerRamp(){
        if(!isMoving()) {
            load.setDock(true);
            return true;
        } return false;
    }
    public void raiseRamp(){ load.setDock(false); }

    public int getCarsLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (!load.dockStatus()) super.move();
    }
}
