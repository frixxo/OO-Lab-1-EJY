package Systems.Factories;

import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
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
import WorldObjects.InterfaceHierarchy.LandVehicle;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
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
        WorldObjectView r = new Car(modelName, position, direction, new Point(70, 50), rh, mh,motor, regNR.generate());
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
        WorldObjectView r = new Car(modelName, position, direction, new Point(70, 50), rh, mh,motor, regNR.generate());
        return r;
    }

    public static WorldObjectView CreateLamborghiniGallardo(Point position, Point2D direction)
    {
        String modelName = "LamborghiniGallardo";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new SpoilerDriver(rh);
        IMotor motor = new StandardMotor(320, mh);
        WorldObjectView r = new Car(modelName, position, direction, new Point(70, 50), rh, mh,motor, regNR.generate());
        return r;
    }

    public static WorldObjectView CreateScania(Point position, Point2D direction)
    {
        String modelName = "Scania";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new StandardMotor(20, mh);
        Storage storage = new StandardStorage(new Flak(), new LoadHandler<Skräp>(10, 2,3, 3, LoadHandler.Principle.FILO));
        WorldObjectView r = new Truck(modelName, position, direction, new Point(70, 50), rh, mh,motor, regNR.generate(), storage);
        return r;
    }

    public static WorldObjectView CreateCarTransport(Point position, Point2D direction)
    {
        String modelName = "CarTransport";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new StandardMotor(20, mh);
        Storage storage =new StandardStorage<Car>(new Ramp(), new LoadHandler(10, 2,3, 3, LoadHandler.Principle.FILO));
        WorldObjectView r = new Truck(modelName, position, direction, new Point(70, 50), rh, mh,motor, regNR.generate(), storage);
        return r;
    }

    public static WorldObjectView CreateCarFerry(Point position, Point2D direction)
    {
        String modelName = "CarFerry";
        RotationHandler rh = new VehicleSteerer();
        MoveHandler mh = new VehicleDriver();
        IMotor motor = new StandardMotor(10, mh);
        Storage storage = new StandardStorage<LandVehicle>(new Ramp(), new LoadHandler( 20, 2, 10, 10, LoadHandler.Principle.FIFO));
        WorldObjectView r = new Ferry(modelName, position, direction, new Point(140,100), rh, mh,motor, regNR.generate(), storage);
        return r;
    }
}
