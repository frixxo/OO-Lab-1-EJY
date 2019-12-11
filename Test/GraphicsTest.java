import WorldObjects.Objects.MotorizedVehicle;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class GraphicsTest {
    /** Has tests for graphics and systems*/

    @Test
    public void TestCollisionX(){
        MotorizedVehicle v = new MotorizedVehicle(new Point(-100,-100),new Point(0,0));
        v.getCollider().Update(v,new Point (100,100));
        assertEquals(v.getPosition().x,0);
    }
    @Test
    public void TestCollisionY(){
        MotorizedVehicle v = new MotorizedVehicle(new Point(-100,-100),new Point(0,0));
        v.getCollider().Update(v,new Point (100,100));
        assertEquals(v.getPosition().y,0);
    }
}
