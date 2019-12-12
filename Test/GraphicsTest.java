import Fuctionality.Motors.StandardMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.VehicleSteerer;
import WorldObjects.Objects.Car;
import WorldObjects.Objects.MotorizedVehicle;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class GraphicsTest {
    /** Has tests for graphics and systems*/

    @Test
    public void TestCollisionX(){
        MoveHandler mh=new VehicleDriver();
        MotorizedVehicle v = new Car("",new Point(-100,-100),new Point(0,0),new Point(20,20),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        v.getCollider().Update(v,new Point (100,100));
        assertEquals(v.getPosition().x,0);
    }
    @Test
    public void TestCollisionY(){
        MoveHandler mh=new VehicleDriver();
        MotorizedVehicle v = new Car("",new Point(-100,-100),new Point(0,0),new Point(20,20),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        v.getCollider().Update(v,new Point (100,100));
        assertEquals(v.getPosition().y,0);
    }
}
