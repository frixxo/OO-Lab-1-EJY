package Fuctionality.MoveHandlers;

import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.Objects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class SpoilerDriver extends VehicleDriver {
    private boolean spoilerUp=false;
    private double spoilerspeed =0;
    private RotationHandler rotationHandler;

    public SpoilerDriver(RotationHandler rotationHandler) {
        super();
        this.rotationHandler = rotationHandler;
    }

    public void raiseSpoiler(){
        if (!spoilerUp) {
        rotationHandler.setTurnAngle(rotationHandler.getTurnAngle() + 5);
        spoilerUp=true;}
    }
    public void lowerSpoiler(){
        if (spoilerUp)
        {
            rotationHandler.setTurnAngle(rotationHandler.getTurnAngle() -5);
            spoilerUp=false;
        }
    }

    @Override
    public void setCurrentSpeed(double d){
        if(spoilerUp){this.currentSpeed=d*0.9;}
        else {super.setCurrentSpeed(d);}
    }
}

