package WorldObjects;

import Fuctionality.*;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TrimmedMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends WorldObject implements Movable, Car, Vehicle{
    private String modelName;
    private RotationHandler steerer= new VehicleSteerer(this);
    private MoveHandler driver= new VehicleDriver(this);
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
    public MoveHandler getDriveHandler() {
        return null;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return null;
    }
}
