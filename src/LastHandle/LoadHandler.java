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

    private boolean isBehind(Movable obj){
        int dX = (int)(movable.getPosition().x + -MAX_LOAD_DISTANCE * movable.getDirection().getX());
        int dY = (int)(movable.getPosition().y + -MAX_LOAD_DISTANCE * movable.getDirection().getY());

        Rectangle rec = new Rectangle(dX-sX, dY-sY, dX+sX, dY+sY);
        return rec.contains(obj.getPosition());
    }

}
