package WorldObjects;

import Fuctionality.*;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends WorldObject implements Movable, Car, Vehicle{
    private String modelName;
    private SteerHandler steerer= new VehicleSteerer(this);
    private DriveHandler driver= new VehicleDriver(this);
    private IMotor motor = new TrimmedMotor(100,1.25,driver);


    //region Constructor
    public Volvo240(Point position, Point2D direction, Point size)
    {
        super(position, direction, size, false);
    }
    //endregion

    @Override
    public IMotor getMotor() {
        return motor;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public DriveHandler getDriveHandler() {
        return null;
    }

    @Override
    public SteerHandler getSteerHandler() {
        return null;
    }
}
