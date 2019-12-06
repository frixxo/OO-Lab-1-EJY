package Fuctionality.MoveHandlers;

import WorldObjects.Objects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class VehicleDriver implements MoveHandler {
    protected double currentSpeed=0;
    protected int frameCounter=1;               //makes sure the car moves every other frame when speed is slow

    @Override
    public Point move(Point position,Point2D direction,boolean Static){
        if(!Static){
            if(currentSpeed*frameCounter<0.5)frameCounter++;
            else { frameCounter=1;}
            return new Point((int)Math.round(position.getX()+direction.getX()*currentSpeed*frameCounter),(int)Math.round(position.getY()+direction.getY()*currentSpeed*frameCounter));
        }
        return position;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public void setCurrentSpeed(double d) { this.currentSpeed=d; }

    @Override
    public boolean isMoving() {
        return (getCurrentSpeed()!=0);
    }

}
