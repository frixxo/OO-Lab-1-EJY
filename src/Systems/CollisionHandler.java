package Systems;

import WorldObjects.IsWorldObject;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.Objects.WorldObject;

import java.awt.*;
import java.awt.geom.Point2D;

public class CollisionHandler {

    public void hasHitWall(WorldObject vehicle, Point Worldsize){
        Point pos = vehicle.getPosition();
        Point2D dir = vehicle.getDirection();
        if(dir.getX() > 0 && pos.x + vehicle.getSize().x >= Worldsize.x ||
                dir.getX() < 0 && pos.x <= 0){
            changeDirection(vehicle,-1,1);
        }
        if(dir.getY() > 0 && pos.y + vehicle.getSize().y>= Worldsize.y ||
                dir.getY() < 0 && pos.y <= 0){
            changeDirection(vehicle,1,-1);
        }

        changePosition(vehicle,Worldsize);
    }
    private void changeDirection(WorldObject vehicle,int x, int y){
        if(vehicle instanceof IHasMotor){((IHasMotor) vehicle).getMotor().stopEngine();}                                    //stops the cars when hitting a wall. if commented cars will turn around instantly and run with same speed the other way
        // vehicle.fixPosition(new Point(frame.getSize().width,frame.getSize().height-240),frame.drawPanel.getImageMap().get(vehicle.getClass()).getSize());
        vehicle.setDirection(new Point.Double(vehicle.getDirection().getX()*x, vehicle.getDirection().getY()*y));
    }

    private void changePosition(WorldObject vehicle,Point Worldsize){
        Point position=vehicle.getPosition();
        Point picsize=vehicle.getSize();

     if(position.x+(picsize.x)>Worldsize.x){        //corrects right
        position.x=(Worldsize.x-(picsize.x));
    }if(position.y+(picsize.y)>Worldsize.y){       //corrects down
        position.y=(Worldsize.y-(picsize.y));
    }if(position.x<0){                              //corrects left
        position.x=0;
    }if(position.y<0){                              //corrects up
        position.y=0;
    }
     vehicle.setPosition(position);
}
}
