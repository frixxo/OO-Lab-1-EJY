package Graphics;

import Systems.CarSimulator;
import Systems.Observer.Observer;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.awt.*;

public class SpeedLabel extends JLabel implements Observer {
    private CarSimulator cs;
    private JLabel label;
    private StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();

        this.cs = cs;

        label = new JLabel();
        this.add(label);
        this.setPreferredSize(size);

        update();
    }

    @Override
    public void update() {
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        label.setText(sb.toString());
        sb.delete(0, sb.length());
    }
}
