package Fuctionality.Storage.LastHandle;

import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.LableInterfaces.WorldObjectView;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * simulates transportation for all kinds
 * */
public class LoadHandler <objectType extends WorldObjectH, object extends IsWorldObject> implements IHandleLast<objectType, object> {
    /**
     * FIFO = First in, first out
     * FILO = First in, last out
     * */
    public enum Principle{FIFO, FILO}

    protected Deque<object> cargoList = new LinkedList<>();

    private final Principle principle;
    protected final int MAX_CARGO_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private final int sX, sY; // size of the cargo
    //private WorldObject LoadingVehicle;

    private boolean loadstate = true;

    public LoadHandler(int maxCargoLoad, int maxLoadDistance, int sX, int sY, Principle principle){
        this.MAX_CARGO_LOAD = maxCargoLoad;
        this.principle = principle;
        this.MAX_LOAD_DISTANCE = maxLoadDistance;
        this.sX = sX;
        this.sY = sY;
    }
    
    public int getCargoCount(){ return cargoList.size(); }

    public boolean load(object cargo, Point position) throws IllegalArgumentException{
        try{
            objectType t = (objectType) cargo.getObjectType();
            cargo.getObjectType().equals(t);
        } catch (ClassCastException e)
        {
            throw new IllegalArgumentException();
        }
        if (cargoList.size() < MAX_CARGO_LOAD
                &&!cargo.getLocked()
                &&isBehind(cargo,position)
                && loadstate
                ) {
            cargo.setLocked(true);
            cargoList.add(cargo);
            return true;
        } return false;
    }

    public object release(){
            object cargo;
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
            cargo.setLocked(false);
            return cargo;
    }

    private boolean isBehind(IsWorldObject obj,Point position){
        if(position.distance(obj.getPosition()) > MAX_LOAD_DISTANCE
                || position.distance(obj.getPosition()) > MAX_LOAD_DISTANCE||obj.getLocked()) return false;
        return true;
    }

    public void setLoadState (boolean loadState)
    {
        this.loadstate = loadState;
    }

    public void updatePosition(Point position){
        for (IsWorldObject cargo : cargoList){
            cargo.setPosition(position);
            if (cargo instanceof IHasStorage){                                 //ser till att alla lastade lastare uppdaterar i sin tur sina lastade saker. ex, en cartransport på en färja ska uppdatera bilarna på sig om färjan rör på sig.
                ((IHasStorage)cargo).getStorage().updatePosition(position);
            }
        }
    }
}
