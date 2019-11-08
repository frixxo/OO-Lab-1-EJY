import java.util.Queue;

public class LoadHandlerQueue<T> extends LoadHandler<T> {

    Queue<T> objectList;
    public LoadHandlerQueue(Vehicle transport, int maxCarLoad, int maxLoadDistance) {
        super(transport, maxCarLoad, maxLoadDistance);
    }

    public void load(T object) throws Exception
    {
        if (canLoad(object, objectList.size()))
        {
            objectList.add(object);
            return;
        } throw new Exception("Cannot load the car!");
    }

    public T release() throws Exception {
        if(canRelease())
        {
            T object = objectList.poll();
            setPos(object);
            return object;
        }  throw new Exception("Ramp not lowered!");
    }
}
