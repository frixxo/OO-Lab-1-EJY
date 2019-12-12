package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.Storage.Storage;
import WorldObjects.LableInterfaces.IHasStorage;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class MotorizedTransportVehicle extends MotorizedVehicle implements IHasStorage {
    private Storage storage;

    protected MotorizedTransportVehicle(String modelName, Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr, Storage storage)
    {
        super(modelName, position, direction, size, steerer, driver, motor, RegNr);
        this.storage = storage;
        this.motor = motor;
    }

    public Storage getStorage(){
        storage.setCanChangeState(!getMoveHandler().isMoving());
        return storage;
    }

    @Override
    public boolean getLocked(){
        return super.getLocked() || storage.getContainer().normalState();
    }

    @Override
    public void move(){
        super.move();
        getStorage().getLastHandler().updatePosition(getPosition());
    }

}
