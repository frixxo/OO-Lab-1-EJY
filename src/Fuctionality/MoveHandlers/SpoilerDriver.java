package Fuctionality.MoveHandlers;

import Fuctionality.MoveHandlers.VehicleDriver;
import WorldObjects.Objects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class SpoilerDriver extends VehicleDriver {
    private boolean spoilerUp=false;
    private double spoilerspeed =0;

    public SpoilerDriver() {
        super();
    }

    public void raiseSpoiler(){
        spoilerUp=true; }
    public void lowerSpoiler(){
        spoilerUp=false; }

    @Override
    public void setCurrentSpeed(double d){
        if(spoilerUp){this.currentSpeed=d*0.9;}
        else {super.setCurrentSpeed(d);}
    }
}

