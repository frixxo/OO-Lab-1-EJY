package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.Storage.Storage;
import WorldObjects.InterfaceHierarchy.LandVehicle;

import java.awt.*;
import java.awt.geom.Point2D;

public class Truck extends MotorizedTransportVehicle implements LandVehicle {
    public Truck(String modelName, Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr, Storage storage) {
        super(modelName, position, direction, size, steerer, driver, motor, RegNr, storage);
    }
}