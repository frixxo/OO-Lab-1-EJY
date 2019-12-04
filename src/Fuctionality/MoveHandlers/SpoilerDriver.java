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
    public Point move(Point position, Point2D direction, boolean Static){
        if(spoilerUp) {
            spoilerspeed =currentSpeed*0.9;}
        else {
            spoilerspeed =currentSpeed;}
        if(!Static){
            if(currentSpeed*frameCounter<0.5)frameCounter++;
            else { frameCounter=1;}
            return new Point((int)Math.round(direction.getX()*currentSpeed*frameCounter),(int)Math.round(direction.getY()*currentSpeed*frameCounter));
        }
        return position;
    }
}

