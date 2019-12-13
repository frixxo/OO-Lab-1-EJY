package Graphics;

import Systems.CarSimulator;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.Objects.Drivable;
import WorldObjects.Objects.WorldObject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpeedLabel extends JLabel {
    private CarSimulator cs;
    StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();
        this.cs=cs;
        initText();
        this.setPreferredSize(size);
    }

    private void initText(){
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        this.setText(sb.toString());
    }

}
