package Fuctionality;

import WorldObjects.WorldObject;

public class VehicleDriver implements DriveHandler {
    private int currentSpeed=0;
    private WorldObject worldObject;
    
    public VehicleDriver(WorldObject worldObject){
        this.worldObject=worldObject;
    }
    @Override
    public void move(){
        if(!IsLoaded){
            if(currentSpeed*frameCounter<0.5)frameCounter++;            //Helps when speed is low so that the car moves every other frame instead of not moving at all
            else { frameCounter=1;}
            position.translate((int)Math.round(direction.getX()*currentSpeed*frameCounter),(int)Math.round(direction.getY()*currentSpeed*frameCounter));
        }
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
}
