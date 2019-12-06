package Fuctionality.Colliders;

import WorldObjects.Objects.WorldObject;

import java.awt.*;

public interface IDynamicCollider extends Collider {
    void Update(WorldObject vehicle, Point Worldsize);
}
