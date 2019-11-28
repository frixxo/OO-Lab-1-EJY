package WorldObjects;

import Fuctionality.IMotor;
import Fuctionality.OldMoveHandlerDontTouchHasThePlague;
import Fuctionality.TurboMotor;
import LableInterfaces.IHasTurbo;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represent a Movables.Saab95
 */
public class Saab95 extends WorldObject implements Car, IHasTurbo {

    private TurboMotor engine = new TurboMotor(20);
    private OldMoveHandlerDontTouchHasThePlague moveHandler;

    //region constructors
    public Saab95(Point position, Point2D direction, Point size, boolean isStatic){
        super(position,direction, size, isStatic);
        moveHandler = new OldMoveHandlerDontTouchHasThePlague(position, direction);
    }

    //endregion
    
    @Override
    public void setTurbo(boolean turbo) { engine.setTurbo(turbo); }
    @Override
    public boolean getTurbo() { return engine.getTurbo(); }
    @Override
    public IMotor getMotor() { return engine; }
    @Override
    public OldMoveHandlerDontTouchHasThePlague getMoveHandler() { return moveHandler; }
}
