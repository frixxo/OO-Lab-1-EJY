package LastHandle;

import Movables.Movable;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * simulates transportation for all kinds
 * */
public class LoadHandler <T extends Movable> implements IHandleLast<T> {
    /**
     * FIFO = First in, first out
     * FILO = First in, last out
     * */
    public enum Principle{FIFO, FILO}

    protected Deque<T> cargoList = new LinkedList<>();

    private boolean dock = false; // simulates all kind of things, truck ramp, actual dock or even a kangaroo pouch
    private final Principle principle;
    protected final int MAX_CARGO_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private final int sX, sY; // size of the cargo
    private Movable movable;

    public LoadHandler(Movable movable, int maxCargoLoad, int maxLoadDistance, int sX, int sY, Principle principle){
        this.MAX_CARGO_LOAD = maxCargoLoad;
        this.principle = principle;
        this.movable=movable;
        this.MAX_LOAD_DISTANCE = maxLoadDistance;
        this.sX = sX;
        this.sY = sY;
    }
    
    public int getCargoCount(){ return cargoList.size(); }

    public boolean load(T cargo){
        if (cargoList.size() < MAX_CARGO_LOAD
                &&!cargo.getIsLoaded()
                &&isBehind(cargo)
                ) {
            cargo.setIsLoaded(true);
            cargoList.add(cargo);
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
            }
            cargo.setIsLoaded(false);
            return cargo;
    }

    public void updatePosition(Point position){
        for (T cargo : cargoList){
            cargo.getPosition().setLocation(position.x, position.y);
        }
    }

    private boolean isBehind(Movable obj){
        if(movable.getPosition().distance(obj.getPosition()) > MAX_LOAD_DISTANCE
                || movable.getPosition().distance(obj.getPosition()) > MAX_LOAD_DISTANCE||obj.getIsLoaded()) return false;
        return true;
    }

    public void updatePosition(Point position){
        for (T cargo : cargoList){
            cargo.getPosition().setLocation(position.x, position.y);
            if (cargo instanceof IHasLast){                                 //ser till att alla lastade lastare uppdaterar i sin tur sina lastade saker. ex, en cartransport på en färja ska uppdatera bilarna på sig om färjan rör på sig.
                ((IHasLast)cargo).IsLoadedMove(position);
            }
        }
    }

}
