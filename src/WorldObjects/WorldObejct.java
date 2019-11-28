package WorldObjects;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class WorldObejct implements WorldObjectView{
    private  Point position;
    private Point2D direction;
    private Point size;

    private boolean isLoaded;

    protected WorldObejct(Point position, Point2D direction, Point size, boolean isLoaded)
    {
       this.position = position;
       this.direction = direction;
       this.size = size;
       this.isLoaded = isLoaded;
    }
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

    public boolean isLoaded()
    {
        return isLoaded;
    }
}
