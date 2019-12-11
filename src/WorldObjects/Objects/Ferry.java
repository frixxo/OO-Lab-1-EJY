package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.Storage.Storage;

import java.awt.*;
import java.awt.geom.Point2D;

public class Ferry extends MotorizedTransportVehicle{
    public Ferry(String modelName, Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr, Storage storage) {
        super(modelName, position, direction, size, steerer, driver, motor, RegNr, storage);
    }
}
