package WorldObjects.Objects;

import Fuctionality.Colliders.Collider;
import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;
import WorldObjects.LableInterfaces.WorldObjectView;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class WorldObject implements WorldObjectView, IsWorldObject {
    private WorldObjectH objectType;
    private Point position;
    private Point2D direction;
    private Point size;
    private boolean isLocked;
    private Collider collider;
    private String type;

    // region Constructor
    protected WorldObject(Point position, Point2D direction, Point size, WorldObjectH objectType, boolean isLoaded,Collider collider,String type)
    {
        this.objectType = objectType;
       this.position = position;
       this.direction = direction;
       this.size = size;
       this.isLocked = isLoaded;
       this.collider=collider;
       this.type=type;
    }
    //endregion

    //region Setters
    public void setLocked(boolean isLoaded)
    {
        this.isLocked = isLoaded;
    }

    public void setPosition(Point position)
     {
       this.position = position;
    }

     public void setDirection(Point2D direction)
    {
       if(!isLocked) this.direction = direction;
    }

     public void setSize(Point size)
    {
       if(!isLocked) this.size = size;
    }
    //endregion

    //region Getters
    public Point getPosition ()
    {
       Point p = new Point (position.x, position.y);
       return p;
    }

    public Point2D getDirection ()
    {
       Point2D p = new Point2D.Double(direction.getX(), direction.getY());
       return p;
    }

    public Point getSize()
    {
        Point p = new Point(size.x, size.y);
        return p;
    }

    public boolean getLocked()
    {
        return isLocked;
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    public void UpdateCollider(Point Worldsize)
    {
        collider.Update(this, Worldsize);
    }

    public String getType(){ return type;}

    public WorldObjectH getObjectType() {
        return objectType;
    }

    //endregion
}
