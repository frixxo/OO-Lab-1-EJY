package WorldObjects;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class WorldObejct {
    private  Point position;
    private Point2D direction;
    private Rectangle size;

    protected WorldObejct(Point position, Point2D direction, Rectangle size)
   {
       this.position = position;
       this.direction = direction;
       this.size = size;
   }

   public void setPosition(Point position)
   {
       this.position = position;
   }

   public void setDirection(Point2D direction)
   {
       this.direction = direction;
   }

   public void setSize(Rectangle size)
   {
       this.size = size;
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

   public Rectangle getSize()
    {
        Rectangle p = new Rectangle(size.x, size.y, size.width, size.height);
        return p;
    }
}
