package LastHandle;

import Movables.Movable;
/** Defines the methods a object that is carrying a movable object T is supposed to do*/
public interface IHasLast <T extends Movable>{
    boolean load(T t);
    T release();
    void move();
}
