package Fuctionality.Storage.LastHandle;

import WorldObjects.IsWorldObject;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.WorldObject;

import Fuctionality.Storage.Containers.Container;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * simulates transportation for all kinds
 * */
public class LoadHandler <T extends IsWorldObject> implements IHandleLast<T> {
    /**
     * FIFO = First in, first out
     * FILO = First in, last out
     * */
    public enum Principle{FIFO, FILO}

    protected Deque<T> cargoList = new LinkedList<>();

    private final Principle principle;
    protected final int MAX_CARGO_LOAD;
    private final int MAX_LOAD_DISTANCE;
    private final int sX, sY; // size of the cargo
    private WorldObject LoadingVehicle;

    public LoadHandler(WorldObject LoadingVehicle, int maxCargoLoad, int maxLoadDistance, int sX, int sY, Principle principle){
        this.MAX_CARGO_LOAD = maxCargoLoad;
        this.principle = principle;
        this.LoadingVehicle=LoadingVehicle;
        this.MAX_LOAD_DISTANCE = maxLoadDistance;
        this.sX = sX;
        this.sY = sY;
    }
    
    public int getCargoCount(){ return cargoList.size(); }

    public boolean load(T cargo,boolean loadstate){
        if (cargoList.size() < MAX_CARGO_LOAD
                &&!cargo.getStatic()
                &&isBehind(cargo)
                && loadstate               //TODO need to check loadstate
                ) {
            cargo.setStatic(true);
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
            cargo.setStatic(false);
            return cargo;
    }

    private boolean isBehind(IsWorldObject obj){
        if(LoadingVehicle.getPosition().distance(obj.getPosition()) > MAX_LOAD_DISTANCE
                || LoadingVehicle.getPosition().distance(obj.getPosition()) > MAX_LOAD_DISTANCE||obj.getStatic()) return false;
        return true;
    }

    public void updatePosition(Point position){
        for (T cargo : cargoList){
            cargo.getPosition().setLocation(position.x, position.y);
            if (cargo instanceof IHasStorage){                                 //ser till att alla lastade lastare uppdaterar i sin tur sina lastade saker. ex, en cartransport på en färja ska uppdatera bilarna på sig om färjan rör på sig.
                ((IHasStorage)cargo).getStorage().updatePosition(position);
            }
        }
    }
}
