package Fuctionality;

import WorldObjects.WorldObject;

public class SpoilerDriver extends VehicleDriver{
    private boolean spoilerUp=false;
    private double spoilerspeed =0;

    public SpoilerDriver(WorldObject worldObject) {
        super(worldObject);
    }

    public void raiseSpoiler(){
        spoilerUp=true; }
    public void lowerSpoiler(){
        spoilerUp=false; }

    @Override
    public void move(){
        if(spoilerUp) {
            spoilerspeed =currentSpeed*0.9;}
        else {
            spoilerspeed =currentSpeed;}
        if(!worldObject.getStatic()){
            if(spoilerspeed*frameCounter<0.5)frameCounter++;
            else { frameCounter=1;}
            worldObject.getPosition().translate((int)Math.round(worldObject.getPosition().getX()*spoilerspeed*frameCounter),(int)Math.round(worldObject.getDirection().getY()*spoilerspeed*frameCounter));
        }
    }
}

