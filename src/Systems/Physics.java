package Systems;

import WorldObjects.Objects.WorldObject;
import WorldObjects.WorldObjectView;

import java.awt.*;
import java.util.ArrayList;

public class Physics {
    Point Worldsize;
    public Physics(Point Worldsize){
        this.Worldsize=Worldsize;
    }

    public void update(WorldObjectView car){
            if(car instanceof WorldObject){
                ((WorldObject) car).updateCollider(Worldsize);
            }
    }
}
