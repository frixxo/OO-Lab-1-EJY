package Fuctionality;

import WorldObjects.Movables.Movable;

import java.awt.*;
import java.awt.geom.Point2D;

public class MoveHandler implements Movable {
    private Point position;
    private Point2D direction;
    private int turnAngle;
    private boolean IsLoaded;
    private int frameCounter=0;

    public MoveHandler(){
        this.position=new Point(0,0);
        this.direction=new Point(1,0);
        this.turnAngle=90;
    }
    public MoveHandler(Point position,Point2D direction){
        this.position=position;
        this.direction=direction;
        this.turnAngle=90;
    }

    public Point getPosition(){ return position; }
    public Point2D getDirection() { return direction; }

    public void turnLeft(){
        rotate(360-turnAngle);
    }
    public void turnRight(){
        rotate(turnAngle);
    }

    /** calculates the rotation of the car when using turn methods (Origo is top left so we had to flip the rotation using -y)
     * @param angle how much to turn
     * */
    private void rotate (double angle)
    {
        angle = angle*(Math.PI/180);
        double x = direction.getX();
        double y = direction.getY();
        direction.setLocation(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) + y*Math.cos(angle));
    }

    /** makes sure that the car is not slightly outside of frame when hitting a wall and puts it back on the border
     * @param windowsize the size of the window cars are allowed to drive in
     * */
    public void fixPosition(Point windowsize, Point picsize){
        if(position.x+(picsize.x)>windowsize.x){      //corrects right
            position.x=(windowsize.x-(picsize.x));
        }if(position.y+(picsize.y)>windowsize.y){     //corrects down
            position.y=(windowsize.y-(picsize.y));
        }if(position.x<0){                              //corrects left
            position.x=0;
        }if(position.y<0){                              //corrects up
            position.y=0;
        }
    }
    public void move(double currentSpeed){
        if(!IsLoaded){
            if(currentSpeed*frameCounter<0.5)frameCounter++;            //Helps when speed is low so that the car moves every other frame instead of not moving at all
            else { frameCounter=1;}
            position.translate((int)Math.round(direction.getX()*currentSpeed*frameCounter),(int)Math.round(direction.getY()*currentSpeed*frameCounter));
        }
    }
}
