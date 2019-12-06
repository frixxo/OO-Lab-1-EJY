package Fuctionality.Colliders;

import WorldObjects.InterfaceHierarchy.IsWorldObject;
import WorldObjects.Objects.WorldObject;

import java.awt.*;

public interface Collider {
    void collision(IsWorldObject vehicle, IsWorldObject thisVehicle);
    void Update(IsWorldObject thisVehicle, Point Worldsize);
    boolean getStatic();
}
