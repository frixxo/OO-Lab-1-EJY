import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends Car{
private boolean spoilerUp;
private boolean epic;

    //region constructors
    public LamborghiniGallardo(Point position, Point2D direction){
        super(position,direction);
        initialize(2,Color.yellow,320,"Lamborghini Gallardo");
        setSpoilerUp(false);
        epic = true;
    }
    public LamborghiniGallardo(){
        super();
        initialize(2,Color.yellow,320,"Lamborghini Gallardo");
        setSpoilerUp(false);
        epic = true;
    }
    //endregion

    public void setSpoilerUp(boolean TrueOrFalse) {
        spoilerUp=TrueOrFalse;
        if(TrueOrFalse)turnAngle = 95;
        else turnAngle=90;
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
