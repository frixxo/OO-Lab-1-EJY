package Fuctionality;

import java.awt.*;
import java.awt.geom.Point2D;

public class MoveHandler {
    private Point position;
    private Point2D direction;
    private int turnAngle;
    private boolean IsLoaded;
    private int frameCounter=0;
    private double currentSpeed=0;

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



    public double getCurrentSpeed(){return currentSpeed;}
    public void setCurrentSpeed(double speed){this.currentSpeed=speed;}



    /** makes sure that the car is not slightly outside of frame when hitting a wall and puts it back on the border
     * @param windowsize the size of the window cars are allowed to drive in
     * */
    public void fixPosition(Point windowsize, Point picsize){
        if(position.x+(picsize.x)>windowsize.x){        //corrects right
            position.x=(windowsize.x-(picsize.x));
        }if(position.y+(picsize.y)>windowsize.y){       //corrects down
            position.y=(windowsize.y-(picsize.y));
        }if(position.x<0){                              //corrects left
            position.x=0;
        }if(position.y<0){                              //corrects up
            position.y=0;
        }
    }

}
