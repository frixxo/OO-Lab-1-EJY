package Systems.Factories;

import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.Motors.TrimmedMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import WorldObjects.InterfaceHierarchy.Vehicle;
import WorldObjects.Objects.Volvo240;

import java.awt.*;
import java.awt.geom.Point2D;

public class VehicleFactory implements IVeheicleFactory {

    private RegNrGenerator regNR = new RegNrGenerator();

    public Vehicle CreateVolvo240 (Point position, Point2D direction)
    {
        String modelName = "Volvo240";
        MoveHandler mh = new VehicleDriver();
        RotationHandler rh = new VehicleSteerer();
        IMotor motor = new TrimmedMotor( 100,1.25,mh);
        Vehicle r = new Volvo240(modelName, position, direction, rh, mh,motor, regNR.generate());
        return r;
    }

}
