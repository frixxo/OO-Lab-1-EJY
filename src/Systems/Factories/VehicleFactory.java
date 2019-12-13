package Systems.Factories;

import Fuctionality.Motors.NormalMotor;
import Systems.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TrimmedMotor;
import Fuctionality.Motors.TurboMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.SpoilerDriver;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.Containers.Flak;
import Fuctionality.Storage.Containers.Ramp;
import Fuctionality.Storage.LastHandle.LoadHandler;
import Fuctionality.Storage.StandardStorage;
import Fuctionality.Storage.Storage;
import WorldObjects.InterfaceHierarchy.*;
import WorldObjects.LableInterfaces.WorldObjectView;
import WorldObjects.Objects.*;

import java.awt.*;
import java.awt.geom.Point2D;

public class VehicleFactory {

    private static RegNrGenerator regNR = new RegNrGenerator();

    public static  WorldObjectView CreateVolvo240 (Point position, Point2D direction)
    {
        String modelName = "Volvo240";
        MoveHandler mh = new VehicleDriver();
        RotationHandler rh = new VehicleSteerer();
        IMotor motor = new TrimmedMotor( 100,1.25,mh);
        WorldObjectView r = new MotorizedVehicle(position, direction, new Point(70, 50), new CarH(){}, rh, mh, motor, regNR.generate(), modelName);
        return r;
    }
    public static WorldObjectView CreateVolvo240 ()
    {
        return CreateVolvo240(new Point (0,0), new Point(1,0));
    }

    public static WorldObjectView CreateSaab95(Point position, Point2D direction)
    {
        String modelName = "Saab95";
        MoveHandler mh = new VehicleDriver();
        RotationHandler rh = new VehicleSteerer();
        IMotor motor = new TurboMotor(100, mh);
        WorldObjectView r = new MotorizedVehicle(position, direction, new Point(70, 50), new CarH(){}, rh, mh,motor, regNR.generate(),modelName);
        return r;
    }
    public static WorldObjectView CreateSaab95()
    {
        return CreateSaab95(new Point (0,0), new Point(1,0));
    }

    public static WorldObjectView CreateLamborghiniGallardo(Point position, Point2D direction)
    {
        String modelName = "LamborghiniGallardo";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new SpoilerDriver(rh);
        IMotor motor = new NormalMotor(320, mh);
        WorldObjectView r = new MotorizedVehicle(position, direction, new Point(70, 50), new CarH(){}, rh, mh,motor, regNR.generate(),modelName);
        return r;
    }
    public static WorldObjectView CreateLamborghiniGallardo()
    {
        return CreateLamborghiniGallardo(new Point (0,0), new Point(1,0));
    }

    public static WorldObjectView CreateScania(Point position, Point2D direction)
    {
        String modelName = "Scania";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new NormalMotor(20, mh);
        Storage storage = new StandardStorage(new Flak(), new LoadHandler<ObjectH>(10, 2,3, 3, LoadHandler.Principle.FILO));
        WorldObjectView r = new MotorizedTransportVehicle(position, direction, new Point(70, 50), new TruckH() {}, rh, mh, motor, regNR.generate(), storage, modelName);
        return r;
    }
    public static WorldObjectView CreateScania()
    {
        return CreateScania(new Point (0,0), new Point(1,0));
    }

    public static WorldObjectView CreateCarTransport(Point position, Point2D direction)
    {
        String modelName = "CarTransport";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new NormalMotor(20, mh);
        Storage storage =new StandardStorage<CarH>(new Ramp(), new LoadHandler(10, 2,3, 3, LoadHandler.Principle.FILO));
        WorldObjectView r = new MotorizedTransportVehicle(position, direction, new Point(70, 50), new TruckH(){}, rh, mh,motor, regNR.generate(), storage,modelName);
        return r;
    }
    public static WorldObjectView CreateCarTransport()
    {
        return CreateCarTransport(new Point (0,0), new Point(1,0));
    }

    public static WorldObjectView CreateCarFerry(Point position, Point2D direction)
    {
        String modelName = "CarFerry";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new NormalMotor(10, mh);
        Storage storage = new StandardStorage<LandVehicleH>(new Ramp(), new LoadHandler( 20, 2, 10, 10, LoadHandler.Principle.FIFO));
        WorldObjectView r = new MotorizedTransportVehicle( position, direction, new Point(140,100), new FerryH(){}, rh, mh,motor, regNR.generate(), storage,modelName);
        return r;
    }
    public static WorldObjectView CreateCarFerry()
    {
        return CreateCarFerry(new Point (0,0), new Point(1,0));
    }
}
