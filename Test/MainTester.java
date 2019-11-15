import org.testng.annotations.Test;

import java.awt.*;
import java.awt.image.ConvolveOp;
import java.util.ArrayList;
import java.util.List;

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
    public void TestTurnleftX(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(0,saab.direction.getX(),0.01);

    }
    @Test
    public void TestTurnleftY(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(1,saab.direction.getY(),0.01);

    }
    @Test
    public void TestTurnRightX(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(0,saab.direction.getX(),0.01);

    }
    @Test
    public void TestTurnRightY(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(-1,saab.direction.getY(),0.01);

    }
    @Test
    public void TestVolvoSpeedfactor(){
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
        assertEquals(1,saab.position.x,0.01);
    }
    @Test
    public void TestMoveY(){
        Saab95 saab=new Saab95();
        saab.gas(1);
        saab.move();
        assertEquals(0,saab.position.y,0.01);
    }
    @Test
    public void TestRegNrGenerator(){
        Saab95 k;
        ArrayList<String> j= new ArrayList<String>();
        for(int x=0;x<1000;x++){
            k=new Saab95();
            for(int y=0; y<(j.size());y++){
                if(j.get(y).equals(k.RegNr)){
                    System.out.println(x+" "+y+" "+k.RegNr);
                    assertTrue(false);
                }
            }
            j.add(k.RegNr);
        }
        assertTrue(true);
    }
    @Test
    public void TestbilverkstadAdd(){
        Bilverkstad<Volvo240> x=new Bilverkstad<Volvo240>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        assertTrue(x.add(y));

    }
    @Test
    public void TestbilverkstadGet(){
        Bilverkstad<Volvo240> x=new Bilverkstad<Volvo240>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        x.add(y);
        assertTrue(x.get(y.RegNr)==y);

    }
    @Test
    public void TestCarTransportloadRampDown(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        assertFalse(x.load(y));
    }
    @Test
    public void TestCarTransportloadRampUp(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.raiseRamp();
        assertTrue(x.load(y));
    }
    @Test
    public void TestCarTransportGet(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.raiseRamp();
        x.load(y);
        assertTrue(x.release()==y);
    }
}