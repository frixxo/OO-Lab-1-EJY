package Systems;

import WorldObjects.InterfaceHierarchy.IsWorldObject;
import WorldObjects.InterfaceHierarchy.Movable;
import WorldObjects.Objects.WorldObject;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

import java.awt.*;

public class Physics {
    Point Worldsize;
    public Physics(Point Worldsize){
        this.Worldsize=Worldsize;
    }

    public void update(WorldObjectView car){
            if(car instanceof Movable){
                if(!((Movable) car).getCollider().getStatic()){
                ((Movable) car).getCollider().Update((Movable)car,Worldsize);
                }
            }
    }
}

