package Fuctionality;

import WorldObjects.WorldObject;

public class VehicleDriver implements MoveHandler {
    private int currentSpeed=0;
    private WorldObject worldObject;
    private int frameCounter;               //makes sure the car moves every other frame when speed is slow

    public VehicleDriver(WorldObject worldObject){
        this.worldObject=worldObject;
    }

    @Override
    public void move(){
        if(!worldObject.getStatic()){
            if(currentSpeed*frameCounter<0.5)frameCounter++;
            else { frameCounter=1;}
            worldObject.getPosition().translate((int)Math.round(worldObject.getPosition().getX()*currentSpeed*frameCounter),(int)Math.round(worldObject.getDirection().getY()*currentSpeed*frameCounter));
        }
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
}
