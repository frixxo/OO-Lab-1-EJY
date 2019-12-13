package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IHasMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class MotorizedVehicle extends Vehicle implements IHasMotor {
    protected IMotor motor;

    //region Constructor
    public MotorizedVehicle(Point position, Point2D direction, Point size, WorldObjectH objectType, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr, String type) {
        super(position, direction, size, objectType,false, steerer, driver, RegNr, type);
        this.motor = motor;
    }
    //endregion

    public IMotor getMotor() { return motor; }
}


