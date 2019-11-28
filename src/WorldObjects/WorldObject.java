package WorldObjects;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class WorldObject implements WorldObjectView{
    private  Point position;
    private Point2D direction;
    private Point size;

    private boolean isStatic;

    protected WorldObject(Point position, Point2D direction, Point size, boolean isStatic)
    {
       this.position = position;
       this.direction = direction;
       this.size = size;
       this.isStatic = isStatic;
    }
    //endregion

    //region Setters
    public void setStatic(boolean isLoaded)
    {
        this.isStatic = isLoaded;
    }

    public void setPosition(Point position)
     {
       if(!isStatic) this.position = position;
    }

     public void setDirection(Point2D direction)
    {
       if(!isStatic) this.direction = direction;
    }

     public void setSize(Point size)
    {
       if(!isStatic) this.size = size;
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

    public boolean getStatic()
    {
        return isStatic;
    }
    //endregion
}
