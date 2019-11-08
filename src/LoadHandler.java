import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public abstract class LoadHandler<T> implements IHandleLast<T>{

    Vehicle transport;
    private final int MAX_CAR_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private boolean ramp;

    public LoadHandler(Vehicle transport, int maxCarLoad, int maxLoadDistance){

        ramp = false;
        MAX_CAR_LOAD = maxCarLoad;
        MAX_LOAD_DISTANCE = maxLoadDistance;
        this.transport = transport;
    }

    protected boolean canLoad (T car, int size)
    {
        return ramp && size < MAX_CAR_LOAD && isCarBehind(car);
    }


    protected boolean canRelease() {
        return ramp;
    }

    protected void setPos(T obj)
    {
        ((Movable)obj).getPosition().setLocation((int)(transport.position.x + -10 * transport.direction.getX()),
                (int)(transport.position.y + -10 * transport.direction.getY()));
    }

    private boolean isCarBehind(T car){
        int dX = (int)(transport.position.x + -MAX_LOAD_DISTANCE * transport.direction.getX());
        int dY = (int)(transport.position.y + -MAX_LOAD_DISTANCE * transport.direction.getY());


        Rectangle rec = new Rectangle(dX-10, dY-10, dX+10, dY+10);
        return rec.contains(((Movable)car).getPosition());
    }
}
