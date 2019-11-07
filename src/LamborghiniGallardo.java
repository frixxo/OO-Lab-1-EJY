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
        initialize();
    }
    public LamborghiniGallardo(){
        super();
        initialize();
    }

    private void initialize(){
        epic = true;
        nrDoors = 2;
        color = Color.yellow;
        enginePower = 320;
        modelName = "Lamborghini Gallardo";
        SetSpoilerUp(false);
    }
    //endregion

    public void SetSpoilerUp(boolean TrueOrFalse) {
        spoilerUp=TrueOrFalse;
        if(TrueOrFalse)turnAngle = 95;
        else turnAngle=90;
    }
    public boolean getSpoilerUp(){
        return spoilerUp;
    }
    public double speedFactor(){
        if(spoilerUp)return enginePower*0.01*0.9;
        return enginePower*0.01;
    }
}
