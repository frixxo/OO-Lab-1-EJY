package Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends Car{
    private boolean spoilerUp;
    private boolean epic;
    private int startturnangle;

    //region constructors
    public LamborghiniGallardo(Point position, Point2D direction){
        super(position,direction);
        initialize(2,Color.yellow,320,"LamborghiniGallardo");
        setstartturnangle();
        setSpoilerUp(false);
        epic = true;
    }
    public LamborghiniGallardo(){
        super();
        initialize(2,Color.yellow,320,"LamborghiniGallardo");
        setstartturnangle();
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
    private void setstartturnangle(){
        startturnangle=turnAngle;
    }
    public boolean getSpoilerUp(){
        return spoilerUp;
    }

    @Override
    public double speedFactor(){
        if(spoilerUp)return enginePower*0.01*0.9;
        return enginePower*0.01;
    }
}
