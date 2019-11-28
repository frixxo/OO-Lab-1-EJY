package WorldObjects;

import Fuctionality.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.TrimmedMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends WorldObject implements Car, Vehicle{
    private String modelName;
    private IMotor motor = new TrimmedMotor(100,1.25);
    private MoveHandler movehandler;

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
    public MoveHandler getMoveHandler() {
        return movehandler;
    }

    @Override
    public String getModelName() {
        return modelName;
    }
}
