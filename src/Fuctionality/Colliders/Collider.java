package Fuctionality.Colliders;

import WorldObjects.Objects.WorldObject;

import java.awt.*;

public interface Collider {
    void collision(WorldObject vehicle,WorldObject thisVehicle);
}
