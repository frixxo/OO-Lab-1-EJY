import Fuctionality.Motors.StandardMotor;
import Fuctionality.Motors.TrimmedMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.SpoilerDriver;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.Containers.Flak;
import Fuctionality.Storage.Containers.Ramp;
import Fuctionality.Storage.LastHandle.LoadHandler;
import Fuctionality.Storage.StandardStorage;
import Fuctionality.Storage.Storage;
import Systems.Factories.VehicleFactory;
import Systems.IDGenerator.IDGenerator;
import Systems.IDGenerator.RegNrGenerator;
import WorldObjects.Objects.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;


/**
 * Has all the test for the vehicles
 */
public class VehicleTester {


   /* @Test
    public void TestGallardoSpoilerDown() {
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        x.getMotor().startEngine();

        x.LowerSpoiler();                       //TODO Kan inte ändra något i Drivern så kan aldrig sänka eller höja spoiler
        x.getMotor().gas(100);
        x.move();
        double d=x.getCurrentSpeed();
        assertEquals(3.2,(float)d,0.01);
    }

    @Test
    public void TestGallardoSpoilerUp(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.RaiseSpoiler();
        x.getMotor().startEngine();
        x.getMotor().gas(100);
        x.move();
        double d=x.getCurrentSpeed();
        assertEquals((float)2.88,(float)d,0.01);
    }*/
    @Test
    public void TestTurnLeftX(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.turnLeft();
        assertEquals(0,x.getDirection().getX(),0.01);
    }
    @Test
    public void TestTurnLeftY(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.turnLeft();

        assertEquals(-1, x.getDirection().getY(), 0.01);
    }
    @Test
    public void TestTurnRightX(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.turnRight();
        assertEquals(0, x.getDirection().getX(), 0.01);
    }
    @Test
    public void TestTurnRightY(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.turnRight();
        assertEquals(1,x.getDirection().getY(),0.01);
    }
    @Test
    public void TestVolvoSpeedFactor(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new TrimmedMotor(100,1.25,mh),"");

        assertEquals(1.25d,x.getMotor().SpeedFactor(),0.01d);
    }
    @Test
    public void TestGasHigher(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new TrimmedMotor(100,1.25,mh),"");

        x.getMotor().startEngine();
        x.getMotor().gas(10);
        assertEquals(1.25d,x.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestBrakeHigher(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.getMotor().startEngine();
        x.getMotor().gas(10);
        x.getMotor().brake(10);
        x.move();
        assertEquals(0,x.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestMoveX(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.getMotor().startEngine();
        x.getMotor().gas(10);
        x.move();
        assertEquals(1,x.getPosition().getX(),0.01);
    }
    @Test
    public void TestMoveY(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        x.getMotor().startEngine();
        x.getMotor().gas(10);
        x.move();
        assertEquals(0,x.getPosition().getY(),0.01);
    }
    @Test   //testar 1000 olika kombinationer, klarar 20000 innan duplicering
    public void TestRegNrGenerator(){
        IDGenerator reg=new RegNrGenerator();
        ArrayList<String> j= new ArrayList<>();
        String Nr="";
        for(int x=0;x<1000;x++){
            Nr=reg.generate();
            for(int y=0; y<(j.size());y++){
                if(j.get(y).equals(Nr)){

                    System.out.println(x+" "+y+ " "+ Nr);
                    fail();
                }
            }
        }
        assertTrue(true);
    }
    @Test
    public void TestBilverkstadAdd(){
        MoveHandler mh=new VehicleDriver();
        Bilverkstad<Car> x=new Bilverkstad<>(new Point(0,0),5);
        Car y=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        assertTrue(x.add(y));

    }
    @Test
    public void TestBilverkstadGet(){
        MoveHandler mh=new VehicleDriver();
        Bilverkstad<Car> x=new Bilverkstad<>(new Point(0,0),5);
        Car y=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"hej81239");

        x.add(y);
        assertSame(x.get(y.getID()), y);
    }
    @Test
    public void TestCarTransportLoadRampDown(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MotorizedTransportVehicle y= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));
        y.getStorage().getContainer().openContainer();
        assertTrue(y.getStorage().getLastHandler().load(x,y.getPosition()));
    }
    @Test
    public void TestCarTransportLoadRampUp(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MotorizedTransportVehicle y= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        y.getStorage().getContainer().closeContainer();
        boolean b=y.getStorage().getLastHandler().load(x,y.getPosition());
        assertFalse(b);
    }
    @Test
    public void TestCarTransportGet(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MotorizedTransportVehicle y= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        y.getStorage().getContainer().openContainer();
        y.getStorage().getLastHandler().load(x,y.getPosition());
        assertSame(y.getStorage().getLastHandler().release(), x);
    }
    @Test
    public void TestCarFerryLoad(){
        MoveHandler mh=new VehicleDriver();
        Car y=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MotorizedTransportVehicle ferry= new Ferry("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        ferry.getStorage().getContainer().openContainer();
        assertTrue(ferry.getStorage().getLastHandler().load(y,ferry.getPosition()));
    }
    @Test
    public void TestCarFerryGet(){
        MoveHandler mh=new VehicleDriver();
        Car y=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MotorizedTransportVehicle ferry= new Ferry("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FIFO)));

        ferry.getStorage().getContainer().openContainer();
        ferry.getStorage().getLastHandler().load(y,ferry.getPosition());
        ferry.getStorage().getLastHandler().load(x,ferry.getPosition());
        assertSame(ferry.getStorage().getLastHandler().release(), y);
    }
    @Test
    public void TestScaniaMoveRampUpX(){
        MoveHandler mh=new VehicleDriver();
       MotorizedTransportVehicle s= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mh, new StandardMotor(100, mh), "", new StandardStorage(new Flak(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        s.getStorage().getContainer().closeContainer();
        Point p = s.getPosition();
        s.getMotor().startEngine();
        s.getMotor().gas(100);
        s.move();
        assertEquals(s.getPosition().getX(),p.x,0.01);
    }
    @Test
    public void TestScaniaMoveRampUpY(){
         MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle s= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Flak(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        s.getStorage().getContainer().closeContainer();
        Point p = s.getPosition();
        s.getMotor().startEngine();
        s.getMotor().gas(100);
        s.move();
        assertEquals(s.getPosition().getY(),p.y,0.01);
    }
    @Test
    public void TestLoadHandlerUpdatePositionX(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle t= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(x,t.getPosition());
        t.getMotor().startEngine();
        t.getMotor().gas(100);
        t.move();
        assertEquals(x.getPosition().x,t.getPosition().x);
    }
    @Test
    public void TestLoadHandlerUpdatePositionY(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle t= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(x,t.getPosition());
        t.getMotor().startEngine();
        t.getMotor().gas(100);
        t.move();
        assertEquals(x.getPosition().y,t.getPosition().y);
    }
    @Test
    public void TestLoadSameCarMultipleTimes(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle t= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(x,t.getPosition());
        assertFalse(t.getStorage().getLastHandler().load(x,t.getPosition()));
    }
    @Test
    public void TestDriveLoadedCarX() {
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle t= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(x,t.getPosition());
        t.getMotor().startEngine();
        t.getMotor().gas(100);
        t.move();
        assertEquals(x.getPosition().getX(), t.getPosition().getX(), 0.01);
    }
    @Test
    public void TestDriveLoadedCarY() {
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle t= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        t.getStorage().getContainer().openContainer();
        t.getStorage().getLastHandler().load(x,t.getPosition());
        x.getMotor().startEngine();
        x.getMotor().gas(100);
        x.move();
        assertEquals(x.getPosition().getY(), t.getPosition().getY(), 0.01);
    }
    @Test
    public void TestLoadCarTransportWithCargoOnFerry(){
        MoveHandler mh=new VehicleDriver();
        Car x=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MoveHandler mk=new VehicleDriver();
        MotorizedTransportVehicle F= new Ferry("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mk, new StandardMotor(100, mk), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle T= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(x,T.getPosition());
        assertTrue( F.getStorage().getLastHandler().load(T,F.getPosition()));
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateX(){
        MoveHandler mh=new VehicleDriver();
        Car V=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MoveHandler mk=new VehicleDriver();
        MotorizedTransportVehicle F= new Ferry("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mk, new StandardMotor(100, mk), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle T= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(V,T.getPosition());
        F.getStorage().getLastHandler().load(T,F.getPosition());
        F.getMotor().startEngine();
        F.getMotor().gas(100);
        F.move();
        assertEquals(V.getPosition().x,F.getPosition().x);
    }
    @Test
    public void TestMoveCarTransportWithCargoOnFerryCargoUpdateY(){
        MoveHandler mh=new VehicleDriver();
        Car V=new Car("", new Point(0,0), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");

        MoveHandler mk=new VehicleDriver();
        MotorizedTransportVehicle F= new Ferry("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mk, new StandardMotor(100, mk), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle T= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        T.getStorage().getContainer().openContainer();
        F.getStorage().getContainer().openContainer();
        T.getStorage().getLastHandler().load(V,T.getPosition());
        F.getStorage().getLastHandler().load(T,F.getPosition());
        F.getMotor().startEngine();
        F.getMotor().gas(100);
        F.move();
        assertEquals(V.getPosition().y,F.getPosition().y);
    }
    @Test
    public void TestLoadWhenNotInMaxLoadDistance(){
        MoveHandler mh=new VehicleDriver();
        Car v=new Car("", new Point(1000,1000), new Point(1,0),new Point (1,1),new VehicleSteerer(),mh,new StandardMotor(100,mh),"");
        MoveHandler mn=new VehicleDriver();
        MotorizedTransportVehicle c= new Truck("", new Point(0, 0), new Point(1, 0), new Point(1, 1), new VehicleSteerer(), mn, new StandardMotor(100, mn), "", new StandardStorage(new Ramp(),new LoadHandler<Car>(5,5,5,5, LoadHandler.Principle.FILO)));

        c.getStorage().getContainer().openContainer();
        assertFalse(c.getStorage().getLastHandler().load(v,c.getPosition()));
    }
}