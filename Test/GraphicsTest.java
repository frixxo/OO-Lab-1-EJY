import Graphics.*;
import WorldObjects.Objects.Volvo240;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
public class GraphicsTest {
    /** Has tests for graphics and systems*/

    @Test
    public void TestCollisionX(){
        Volvo240 v = new Volvo240(new Point(-100,-100),new Point(0,0));
        v.updateCollider(new Point (10,10));
        assertEquals(v.getPosition().x,0);
    }
    @Test
    public void TestCollisionY(){
        Volvo240 v = new Volvo240(new Point(-100,-100),new Point(0,0));
        v.updateCollider(new Point (10,10));
        assertEquals(v.getPosition().y,0);
    }
}
