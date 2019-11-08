import java.util.Deque;
import java.util.Stack;

public class LoadHandlerStack<T> extends LoadHandler<T> {

    protected Deque<T> objectList;
    public LoadHandlerStack(Vehicle transport, int maxCarLoad, int maxLoadDistance) {
        super(transport, maxCarLoad, maxLoadDistance);
    }

    public void load(T object) throws Exception
    {
        if (canLoad(object, objectList.size()))
        {
            objectList.push(object);
            return;
        } throw new Exception("Cannot load the car!");
    }

    public T release() throws Exception {
        if(canRelease())
        {
            T object = objectList.pop();
            setPos(object);
            return object;
        }  throw new Exception("Ramp not lowered!");
    }
}
