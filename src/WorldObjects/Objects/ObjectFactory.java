package WorldObjects.Objects;

import Systems.Physics;

import java.awt.*;
import java.awt.geom.Point2D;

public class ObjectFactory {
    static public WorldObject createCarFerry(){
        return new CarFerry();
    }

    static public WorldObject createCarFerry(Point position, Point2D direction){
        return new CarFerry(position, direction);
    }

    static public WorldObject createCarTransport(){
        return new CarTransport();
    }

    static public WorldObject createCarTransport(Point position, Point2D direction){
        return new CarTransport(position, direction);
    }


    static public WorldObject createLamborghiniGallardo(){
        return new LamborghiniGallardo();
    }

    static public WorldObject createLamborghiniGallardo(Point position, Point2D direction){
        return new LamborghiniGallardo(position, direction);
    }

    static public WorldObject createSaab95(){
        return new Saab95();
    }

    static public WorldObject createSaab95(Point position, Point2D direction){
        return new Saab95(position, direction);
    }

    static public WorldObject createVolvo240(){
        return new Volvo240();
    }

    static public WorldObject createVolvo240(Point position, Point2D direction){
        return new Volvo240(position, direction);
    }

    static public WorldObject createScania(){
        return new Scania();
    }

    static public WorldObject createScania(Point position, Point2D direction){
        return new Scania(position, direction);
    }

    static public Physics getPhysics(Point size){
        return new Physics(size);
    }
}
