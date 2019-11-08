import java.util.Deque;
import java.util.LinkedList;

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
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
=======
/**
 * simulates transportation for all kinds
 * */
public class LoadHandler<T> {
    public enum Principle{FIFO, FILO}

    Deque<T> cargoList = new LinkedList<>();
    T transport;

    private boolean loadingPlatform = false; // can be all kind of things, even a kangaroo pouch
    private final Principle principle;
    private final int MAX_CARGO_LOAD;

    public LoadHandler(T transport, int maxCargoLoad, Principle principle){
        this.transport = transport;
        this.MAX_CARGO_LOAD = maxCargoLoad;
        this.principle = principle;
    }

    public int getCargoCount(){ return cargoList.size(); }
    public boolean loadingPlatformStatus(){ return loadingPlatform; }
    public void setLoadingPlatform(boolean bool){ loadingPlatform = bool; }

    public boolean load(T car){
        if (cargoList.size() < MAX_CARGO_LOAD) {
            cargoList.add(car);
            return true;
        } return false;
    }

    public T release(){
        T cargo;
        switch (principle){
            case FILO:
                cargo = cargoList.pollLast();
                break;
            case FIFO:
                cargo = cargoList.pollFirst();
                break;
            default:
                cargo = null;
        } return cargo;
    }

>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
}
