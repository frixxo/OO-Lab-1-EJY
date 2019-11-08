import java.util.Deque;
import java.util.LinkedList;

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

}
