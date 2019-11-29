package WorldObjects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.RotationHandler;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends WorldObject implements Car,Movable,Vehicle{
    private boolean spoilerUp;
    private boolean epic;
    private int startturnangle;

    //region constructors
    public LamborghiniGallardo(Point position, Point2D direction,Point size){
        super(position,direction,size,false);
        setSpoilerUp(false);
        epic = true;
    }
    //endregion
    public void raiseSpoiler(){
        if(spoilerUp=false)this.currentSpeed=currentSpeed*1.1;
        setSpoilerUp(true);
    }
    public void lowerSpoiler(){
        if(spoilerUp=true)this.currentSpeed=currentSpeed*0.9;
        setSpoilerUp(false);
    }
    private void setSpoilerUp(boolean TrueOrFalse) {
        spoilerUp=TrueOrFalse;
        if(TrueOrFalse)turnAngle = startturnangle+10;
        else turnAngle=startturnangle;
    }


    @Override
    public IMotor getMotor() {
        return null;
    }

    @Override
    public MoveHandler getDriveHandler() {
        return null;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return null;
    }

    @Override
    public String getModelName() {
        return null;
    }

    @Override
    public String getRegNr() {
        return null;
    }
}
