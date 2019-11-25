package Gui;

import Movables.*;
import WorldObjects.Movables.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private List<Vehicle> vehicles;
    private HashMap <Object,ImageWithSize> imageMap=new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
        initializeHashmap();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image I;
        Point size;
        for (Vehicle v : vehicles) {
           I=imageMap.get(v.getClass()).getImage();
           size =imageMap.get(v.getClass()).getSize();
            g.drawImage(I, v.getPosition().x, v.getPosition().y,size.x,size.y,null); // see javadoc for more info on the parameters
        }
    }
    private void initializeHashmap(){
        imageMap.put(Volvo240.class,new ImageWithSize("/Volvo240.jpg",new Point(70,50)));
        imageMap.put(Saab95.class,new ImageWithSize("/Saab95.jpg",new Point(70,50)));
        imageMap.put(LamborghiniGallardo.class,new ImageWithSize("/LamborghiniGallardo.jpg",new Point(70,50)));
        imageMap.put(Scania.class,new ImageWithSize("/Scania.jpg",new Point(70,50)));
        imageMap.put(CarTransport.class,new ImageWithSize("/Cartransport.jpg",new Point(70,50)));
        imageMap.put(CarFerry.class,new ImageWithSize("/CarFerry.jpg",new Point(140,100)));
    }

    public <T> Point getSize(T obj){ return imageMap.get(obj.getClass()).getSize(); }

    public HashMap<Object, ImageWithSize> getImageMap() { return imageMap; }
}
