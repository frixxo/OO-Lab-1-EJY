import Movables.*;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Has all the test
 */
public class MainTester {

    @Test
    public void TestGallardoSpoilerDown() {
        LamborghiniGallardo x = new LamborghiniGallardo();
        double d=x.speedFactor();
        assertEquals(3.2,d,0);
    }

    @Test
    public void TestGallardoSpoilerUp(){
        LamborghiniGallardo x = new LamborghiniGallardo();
        x.setSpoilerUp(true);
        double d=x.speedFactor();
        assertEquals((float)2.88,(float)d,0);
    }

    @Test
    public void TestTurnLeftX(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(0,saab.getDirection().getX(),0.01);

    }
    @Test
    public void TestTurnLeftY(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(1,saab.getDirection().getY(),0.01);

    }
    @Test
    public void TestTurnRightX(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(0,saab.getDirection().getX(),0.01);

    }
    @Test
    public void TestTurnRightY(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(-1,saab.getDirection().getY(),0.01);

    }
    @Test
    public void TestVolvoSpeedFactor(){
        Volvo240 volvo = new Volvo240();
        assertEquals(1.25d,volvo.speedFactor(),0.01d);
    }
    @Test
    public void TestGasHigher(){
        Volvo240 volvo=new Volvo240();
        volvo.gas(10);
        assertEquals(1.25d,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestBrakeHigher(){
        Volvo240 volvo=new Volvo240();
        volvo.gas(10);
        volvo.brake(10);
        assertEquals(0,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestMoveX(){
        Saab95 saab=new Saab95();
        saab.gas(1);
        saab.move();
        assertEquals(1,saab.getPosition().getX(),0.01);
    }
    @Test
    public void TestMoveY(){
        Saab95 saab=new Saab95();
        saab.gas(1);
        saab.move();
        assertEquals(0,saab.getPosition().getY(),0.01);
    }
    @Test   //testar 500 olika kombinationer, klarar över 20000 innan duplicering
    public void TestRegNrGenerator(){
        Saab95 k;
        ArrayList<String> j= new ArrayList<>();
        for(int x=0;x<500;x++){
            k=new Saab95();
            for(int y=0; y<(j.size());y++){
                if(j.get(y).equals(k.getRegNr())){
                    System.out.println(x+" "+y+" "+k.getRegNr());
                    fail();
                }
            }
            j.add(k.getRegNr());
        }
        assertTrue(true);
    }
    @Test
    public void TestBilverkstadAdd(){
        Bilverkstad<Volvo240> x=new Bilverkstad<>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        assertTrue(x.add(y));

    }
    @Test
    public void TestBilverkstadGet(){
        Bilverkstad<Volvo240> x=new Bilverkstad<>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        x.add(y);
        assertSame(x.get(y.getRegNr()), y);
    }
    @Test
    public void TestCarTransportLoadRampDown(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.lowerRamp();
        assertTrue(x.load(y));
    }
    @Test
    public void TestCarTransportLoadRampUp(){
        Point z=new Point(0,0);
        CarTransport x=new CarTransport(z,z);
        Volvo240 y= new Volvo240();
        x.raiseRamp();
        assertFalse(x.load(y));
    }
    @Test
    public void TestCarTransportGet(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.lowerRamp();
        x.load(y);
        assertSame(x.release(), y);
    }
    @Test
    public void TestCarFerryLowerRamp(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();

        assertTrue(ferry.lowerRamp());
    }
    @Test
    public void TestCarFerryLoad(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.lowerRamp();
        assertTrue(ferry.load.load(y));
    }
    @Test
    public void TestCarFerryGet(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.lowerRamp();
        ferry.load(y);
        ferry.load.load(new Saab95());
        assertSame(ferry.load.release(), y);
    }
    @Test
    public void TestScaniaMoveRampUpX(){
        Scania s = new Scania();
        s.raiseRamp();
        Point p = s.getPosition();
        s.move();
        assertEquals(s.getPosition().getX(),p.x,0.01);
    }
    @Test
    public void TestScaniaMoveRampUpY(){
        Scania s = new Scania();
        s.raiseRamp();
        Point p = s.getPosition();
        s.move();
        assertEquals(s.getPosition().getY(),p.y,0.01);
    }
    @Test
    public void TestLoadHandlerUpdatePositionX(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.lowerRamp();
        t.load(v);
        t.gas(100);
        t.move();
        assertEquals(v.getPosition().x,t.getPosition().x);
    }
    @Test
    public void TestLoadHandlerUpdatePositionY(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.lowerRamp();
        t.load(v);
        t.gas(100);
        t.move();
        assertEquals(v.getPosition().y,t.getPosition().y);
    }
    @Test
    public void TestLoadSameCarMultipleTimes(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.lowerRamp();
        t.load(v);
        assertFalse(t.load(v));
    }
    @Test
    public void TestDriveLoadedCarX() {
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.lowerRamp();
        t.load(v);
        v.gas(100);
        v.move();
        System.out.println(v.getIsLoaded());
        assertEquals(v.getPosition().getX(), t.getPosition().getX(), 0.01);
    }
    @Test
    public void TestDriveLoadedCarY() {
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.lowerRamp();
        t.load(v);
        v.gas(100);
        v.move();
        assertEquals(v.getPosition().getY(), t.getPosition().getY(), 0.01);
    }
    @Test
    public void TestLoadCarTransportWithCargoOnFerry(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.lowerRamp();
        F.lowerRamp();
        T.load(V);
        assertTrue(F.load(T));
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateX(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.lowerRamp();
        F.lowerRamp();
        T.load(V);
        F.load(T);
        F.gas(100);
        F.move();
        assertEquals(V.getPosition().x,F.getPosition().x);
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateY(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.lowerRamp();
        F.lowerRamp();
        T.load(V);
        F.load(T);
        F.gas(100);
        F.move();
        assertEquals(V.getPosition().y,F.getPosition().y);
    }
    @Test
    public void TestLoadWhenNotInMaxLoadDistance(){
        CarTransport c=new CarTransport();
        Point x=new Point(100,100);
        Volvo240 v=new Volvo240(x,x);
        assertFalse(c.load(v));
    }
}