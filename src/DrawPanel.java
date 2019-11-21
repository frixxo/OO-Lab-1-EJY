import Movables.Vehicle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private List<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image I = null;
        for (Vehicle v : vehicles) {
            try {
                I = ImageIO.read(new File(v.getPicturePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(I, v.getPosition().x, v.getPosition().y, null); // see javadoc for more info on the parameters
        }
    }
}
