package LastHandle;

import WorldObjects.Movables.Movable;

import java.awt.*;

/** Defines the methods a object that is carrying a movable object T is supposed to do*/
public interface IHasLast <T extends Movable>{
    boolean load(T t);
    T release();
    void move();            //Needs to override and call on updateposition();
    boolean loadState();
    /** Method that is called when the cargo transporter X is the cargo of a greater cargo transporterY, and makes sure that cargo loaded on X also updates their position to
     * @param p The point to which we want to move the cargo.
     * */
    void IsLoadedMove(Point p);
}
