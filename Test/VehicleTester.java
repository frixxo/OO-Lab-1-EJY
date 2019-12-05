import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import WorldObjects.Objects.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Has all the test
 */
public class VehicleTester {

    @Test
    public void TestGallardoSpoilerDown() {
        LamborghiniGallardo x = new LamborghiniGallardo();
        x.LowerSpoiler();
        x.getMotor().gas(100);
        x.move();
        double d=x.getCurrentSpeed();
        assertEquals(3.2,(float)d,0.01);
    }

    @Test
    public void TestGallardoSpoilerUp(){
        LamborghiniGallardo x = new LamborghiniGallardo();
        x.RaiseSpoiler();
        x.getMotor().gas(100);
        x.move();
        double d=x.getCurrentSpeed();
        assertEquals((float)2.88,(float)d,0.01);
    }
    @Test
    public void TestTurnLeftX(){
        Saab95 saab = new Saab95(new Point(0,0),new Point(1,0),null);
        saab.turnLeft();
        assertEquals(0,saab.getDirection().getX(),0.01);
    }
    @Test
    public void TestTurnLeftY(){
        Saab95 saab = new Saab95(new Point(0,0),new Point(1,0),null);
        saab.turnLeft();

        assertEquals(-1, saab.getDirection().getY(), 0.01);
    }
    @Test
    public void TestTurnRightX(){
        Saab95 saab = new Saab95(new Point(0,0),new Point(1,0),null);
        saab.turnRight();
        assertEquals(0, saab.getDirection().getX(), 0.01);
    }
    @Test
    public void TestTurnRightY(){
        Saab95 saab = new Saab95(new Point(0,0),new Point(1,0),null);
        saab.turnRight();
        assertEquals(1,saab.getDirection().getY(),0.01);
    }
    @Test
    public void TestVolvoSpeedFactor(){
        Volvo240 volvo = new Volvo240(new Point(0,0),new Point(1,0),null);
        assertEquals(1.25d,volvo.getMotor().SpeedFactor(),0.01d);
    }
    @Test
    public void TestGasHigher(){
        Volvo240 volvo=new Volvo240(new Point(0,0),new Point(1,0),null);
        volvo.getMotor().gas(10);
        assertEquals(1.25d,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestBrakeHigher(){
        Volvo240 volvo=new Volvo240(new Point(0,0),new Point(1,0),null);
        volvo.getMotor().gas(10);
        volvo.getMotor().brake(10);
        volvo.move();
        assertEquals(0,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestMoveX(){
        Saab95 saab=new Saab95();
        saab.getMotor().gas(10);
        saab.move();
        assertEquals(1,saab.getPosition().getX(),0.01);
    }
    @Test
    public void TestMoveY(){
        Saab95 saab=new Saab95();
        saab.getMotor().gas(10);
        saab.move();
        assertEquals(0,saab.getPosition().getY(),0.01);
    }
    @Test   //testar 500 olika kombinationer, klarar över 20000 innan duplicering
    public void TestRegNrGenerator(){
        IDGenerator reg=new RegNrGenerator();
        List<String> j= new ArrayList<>();
        String Nr="";
        for(int x=0;x<1000;x++){
            Nr=reg.generate();
            for(int y=0; y<(j.size());y++){
                if(j.get(y).equals(Nr)){

                    fail();
                }
            }
            j.add(Nr);
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
        x.getStorage().getContainer().openContainer();
        assertTrue(x.getStorage().getLastHandler().load(y));
    }
    @Test
    public void TestCarTransportLoadRampUp(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.getStorage().getContainer().closeContainer();
        boolean b=x.getStorage().getLastHandler().load(y);
        assertFalse(b);
    }
    @Test
    public void TestCarTransportGet(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.getStorage().getContainer().closeContainer();
        x.getStorage().getLastHandler().load(y);
        assertSame(x.getStorage().getLastHandler().release(), y);
    }
    @Test
    public void TestCarFerryLoad(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.getStorage().getContainer().openContainer();
        assertTrue(ferry.getStorage().getLastHandler().load(y));
    }
    @Test
    public void TestCarFerryGet(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.getStorage().getContainer().openContainer();
        ferry.getStorage().getLastHandler().load(y);
        ferry.getStorage().getLastHandler().load(new Saab95());
        assertSame(ferry.getStorage().getLastHandler().release(), y);
    }
    @Test
    public void TestScaniaMoveRampUpX(){
        Scania s = new Scania();
        s.getStorage().getContainer().closeContainer();
        Point p = s.getPosition();
        s.getMotor().gas(100);
        s.move();
        assertEquals(s.getPosition().getX(),p.x,0.01);
    }
    @Test
    public void TestScaniaMoveRampUpY(){
        Scania s = new Scania();
        s.getStorage().getContainer().closeContainer();
        Point p = s.getPosition();
        s.getMotor().gas(100);
        s.move();
        assertEquals(s.getPosition().getY(),p.y,0.01);
    }
    @Test
    public void TestLoadHandlerUpdatePositionX(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(v);
        t.getMotor().gas(100);
        t.move();
        assertEquals(v.getPosition().x,t.getPosition().x);
    }
    @Test
    public void TestLoadHandlerUpdatePositionY(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(v);
        t.getMotor().gas(100);
        t.move();
        assertEquals(v.getPosition().y,t.getPosition().y);
    }
    @Test
    public void TestLoadSameCarMultipleTimes(){
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(v);
        assertFalse(t.getStorage().getLastHandler().load(v));
    }
    @Test
    public void TestDriveLoadedCarX() {
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(v);
        t.getMotor().gas(100);
        t.move();
        assertEquals(v.getPosition().getX(), t.getPosition().getX(), 0.01);
    }
    @Test
    public void TestDriveLoadedCarY() {
        CarTransport t = new CarTransport();
        Volvo240 v = new Volvo240();
        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(v);
        t.getMotor().gas(100);
        t.move();
        assertEquals(v.getPosition().getY(), t.getPosition().getY(), 0.01);
    }
    @Test
    public void TestLoadCarTransportWithCargoOnFerry(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(V);
        assertTrue( F.getStorage().getLastHandler().load(T));
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateX(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(V);
        F.getStorage().getLastHandler().load(T);
        F.getMotor().gas(100);
        F.move();
        assertEquals(V.getPosition().x,F.getPosition().x);
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateY(){
        CarFerry F = new CarFerry();
        CarTransport T = new CarTransport();
        Volvo240 V = new Volvo240();
        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(V);
        F.getStorage().getLastHandler().load(T);
        F.getMotor().gas(100);
        F.move();
        assertEquals(V.getPosition().y,F.getPosition().y);
    }
    @Test
    public void TestLoadWhenNotInMaxLoadDistance(){
        CarTransport c=new CarTransport();
        Point x=new Point(100,100);
        Volvo240 v=new Volvo240(x,x,new Point (10,10));
        assertFalse(c.getStorage().getLastHandler().load(v));
    }
}