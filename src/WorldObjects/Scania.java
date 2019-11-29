package WorldObjects; /** A scania truck*/
import Flak.Flak;
import Fuctionality.MoveHandler;
import Fuctionality.Motors.NormalMotor;
import Fuctionality.Motors.StandardMotor;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends WorldObject implements Vehicle {
    private final static String model = "Scania";
    private StandardMotor engine = new StandardMotor(20);
    private MoveHandler moveHandler;
    private Flak flak= new Flak();

    public Scania(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position,direction, size, isStatic);
    }

    public MoveHandler getMoveHandler(){ return moveHandler; }
    public NormalMotor getMotor(){ return engine; }

    @Override
    public String getModelName() { return model; }
}
