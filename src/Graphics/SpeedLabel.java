package Graphics;

import Systems.CarSimulator;
import Systems.Observer.Observer;
import Systems.Observer.Observerable;
import WorldObjects.LableInterfaces.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.awt.*;

public class SpeedLabel extends JLabel implements Observer {
    private CarSimulator cs;
    StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();
        this.cs=cs;
        this.setPreferredSize(new Dimension(800, 40));
        cs.addObserver(this);
        update();
    }

    public void update() {
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        this.setText("<html>"+ sb.toString() +"</html>");
        sb.delete(0, sb.length());
    }
}
