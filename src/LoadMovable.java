import java.awt.*;

/**
 * class extended for Movable object
 * */
public class LoadMovable extends LoadHandler {
    private Movable movable;

    private final int MAX_LOAD_DISTANCE;
    private final int sX, sY; // size of the cargo

    public LoadMovable(Movable movable, int maxCargoLoad, int maxLoadDistance, int sX, int sY, Principle principle) {
        super(maxCargoLoad, principle);
        this.movable = movable;
        this.MAX_LOAD_DISTANCE = maxLoadDistance;
        this.sX = sX;
        this.sY = sY;
    }

    @Override
    public boolean load(Object cargo) {
        if (cargoList.size() < MAX_CARGO_LOAD && cargo instanceof Movable &&
                dockStatus() && isBehind((Movable)cargo)) {
            cargoList.add(cargo);
            return true;
        } return false;
    }


    private boolean isBehind(Movable obj){
        int dX = (int)(movable.getPosition().x + -MAX_LOAD_DISTANCE * movable.getDirection().getX());
        int dY = (int)(movable.getPosition().y + -MAX_LOAD_DISTANCE * movable.getDirection().getY());

        Rectangle rec = new Rectangle(dX-sX, dY-sY, dX+sX, dY+sY);
        return rec.contains(obj.getPosition());
    }

}
