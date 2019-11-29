package WorldObjects; /** A scania truck*/
import Flak.Flak;
import Fuctionality.MoveHandler;
import Fuctionality.Motors.NormalMotor;
import Fuctionality.Motors.StandardMotor;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Scania extends WorldObject implements Vehicle {
    private final static String model = "Scania";
    private StandardMotor engine = new StandardMotor(20);
    private MoveHandler moveHandler;
    private Flak flak= new Flak();
    private String ModelName="Scania";
    private String RegNr;



    public Scania(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position,direction, size, isStatic);
        Random r = new Random(ObjectNr);
        this.RegNr=(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+" "+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);
    }

    public MoveHandler getMoveHandler(){ return moveHandler; }
    public NormalMotor getMotor(){ return engine; }

    @Override
    public String getModelName() { return model; }

    @Override
    public String getRegNr() {
        return null;
    }
}
