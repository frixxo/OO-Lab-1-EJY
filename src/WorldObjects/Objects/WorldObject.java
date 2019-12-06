package WorldObjects.Objects;

import Fuctionality.Colliders.Collider;
import WorldObjects.InterfaceHierarchy.IsWorldObject;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class WorldObject implements WorldObjectView, IsWorldObject {
    private Point position;
    private Point2D direction;
    private Point size;
    private boolean isLoaded;
    private Collider collider;

    // region Constructor
    protected WorldObject(Point position, Point2D direction, Point size, boolean isLoaded,Collider collider)
    {
       this.position = position;
       this.direction = direction;
       this.size = size;
       this.isLoaded = isLoaded;
       this.collider=collider;
    }
    //endregion

    //region Setters
    public void setLoaded(boolean isLoaded)
    {
        this.isLoaded = isLoaded;
    }

    public void setPosition(Point position)
     {
       if(!isLoaded) this.position = position;
    }

     public void setDirection(Point2D direction)
    {
       if(!isLoaded) this.direction = direction;
    }

     public void setSize(Point size)
    {
       if(!isLoaded) this.size = size;
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

    public boolean getLoaded()
    {
        return isLoaded;
    }

    @Override
    public Collider getCollider() {
        return collider;
    }
    //endregion
}
