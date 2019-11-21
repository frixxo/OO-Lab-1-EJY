import Movables.Car;
import Movables.Volvo240;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private Image I;
    private Volvo240 volvo = new Volvo240();
    private List<Car> cars;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars=cars;
    }

    public void moveit(int x, int y){
        volvo.set(x, y);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            I=ImageIO.read(new File(volvo.getPicturePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(I, volvo.getPosition().x, volvo.getPosition().y, null); // see javadoc for more info on the parameters
    }
}
