package Systems;

import WorldObjects.Objects.WorldObject;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

import java.awt.*;

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
