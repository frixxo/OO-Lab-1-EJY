import java.util.Deque;
import java.util.LinkedList;

/**
 * simulates transportation for all kinds
 * */
public class LoadHandler<T> {
    /**
     * FIFO = First in, first out
     * FILO = First in, last out
     * */
    public enum Principle{FIFO, FILO}

    protected Deque<T> cargoList = new LinkedList<>();

    private boolean dock = false; // simulates all kind of things, truck ramp, actual dock or even a kangaroo pouch
    private final Principle principle;
    protected final int MAX_CARGO_LOAD;

    public LoadHandler(int maxCargoLoad, Principle principle){
        this.MAX_CARGO_LOAD = maxCargoLoad;
        this.principle = principle;
    }

    public int getCargoCount(){ return cargoList.size(); }
    public boolean dockStatus(){ return dock; }
    public void setDock(boolean bool){ dock = bool; }

    public boolean load(T cargo){
        if (cargoList.size() < MAX_CARGO_LOAD && dockStatus()) {
            cargoList.add(cargo);
            return true;
        } return false;
    }

    public T release(){
        if (dockStatus()){
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
            }
            return cargo;
        } return null;
    }

}
