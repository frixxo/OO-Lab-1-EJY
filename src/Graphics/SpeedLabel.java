package Graphics;

import Systems.CarSimulator;
import Systems.Observer.Observer;
import Systems.Observer.Observerable;
import WorldObjects.LableInterfaces.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class SpeedLabel extends JLabel implements Observer {
    private CarSimulator cs;
    StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();
        this.cs=cs;
        update();
        this.setPreferredSize(new Dimension(800, 20));
        cs.addObserver(this);
        update();
    }

    public void update() {
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ");
                int x= (int) (((Drivable)vehicle).getCurrentSpeed()*100);
                sb.append(((double)x)/100);
                sb.append("; ");
            }
        }
        this.setText(sb.toString());
        sb.delete(0, sb.length());
    }
}
