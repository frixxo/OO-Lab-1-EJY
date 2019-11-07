import java.awt.*;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends Car{
private boolean spoilerUp;
public boolean epic;

    public LamborghiniGallardo(){
        epic = true;
        nrDoors = 2;
        color = Color.yellow;
        enginePower = 320;
        modelName = "Lamborghini Gallardo";
        SetSpoilerUp(false);
        stopEngine();
    }

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
