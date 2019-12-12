package WorldObjects.Objects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class Vehicle extends Drivable {
    private String modelName="Volvo240";
    private String ID;

    protected Vehicle (String modelName, Point position, Point2D direction, Point size, boolean isStatic, RotationHandler rotationHandler, MoveHandler moveHandler, String id)
    {
        super(position, direction, size, isStatic, rotationHandler, moveHandler);
        this.modelName = modelName;
        this.ID = id;
    }

    public String getModelName() {
        return modelName;
    }

    public String getID() {
        return ID;
    }
}
