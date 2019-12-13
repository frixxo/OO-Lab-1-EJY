package Graphics;

import Systems.CarSimulator;
import WorldObjects.Objects.*;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private HashMap <String, ImageHandler> imageMap=new HashMap<>();
    private CarSimulator cs;

    // Initializes the panel and reads the images
    public DrawPanel(Dimension dim, CarSimulator cs) {
        this.cs = cs;
        this.setDoubleBuffered(true);
        this.setPreferredSize(dim);
        this.setBackground(Color.green);
        initializeHashmap();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image;
        Point size;
        for (WorldObjectView v : cs.getVehicles()) {
           image = imageMap.get(v.getType()).getImage();
           size = v.getSize();
           g.drawImage(image, v.getPosition().x, v.getPosition().y,size.x,size.y,null); // see javadoc for more info on the parameters
        }
    }

    private void initializeHashmap(){ //TODO fix
        imageMap.put("Volvo240", new ImageHandler("/Volvo240.jpg"));
        imageMap.put("Saab95", new ImageHandler("/Saab95.jpg"));
        imageMap.put("LamborghiniGallardo", new ImageHandler("/LamborghiniGallardo.jpg"));
        imageMap.put("Scania", new ImageHandler("/Scania.jpg"));
        imageMap.put("CarTransport", new ImageHandler("/Cartransport.jpg"));
        imageMap.put("CarFerry", new ImageHandler("/CarFerry.jpg"));
    }

   // public <T> Point getSize(T obj){ return imageMap.get(obj.getClass()).getSize(); }

    public HashMap<String, ImageHandler> getImageMap() { return imageMap; }
}
