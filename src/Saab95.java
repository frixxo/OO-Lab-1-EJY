import java.awt.*;

/**
 * represent a Saab95
 */
public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 4;
        color = Color.red;
        enginePower = 125;
        modelName = "Saab95";
        setTurboOn(false);
        stopEngine();
    }

    public void setTurboOn(boolean TrueOrFalse){
	    turboOn = TrueOrFalse;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
