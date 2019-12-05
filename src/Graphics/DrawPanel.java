package Graphics;

import WorldObjects.Objects.*;
import WorldObjects.WorldObjectView;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private List<WorldObjectView> worldObjects;
    private HashMap <Object,ImageWithSize> imageMap=new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<WorldObjectView> worldObjects) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.worldObjects = worldObjects;
        initializeHashmap();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image I;
        Point size;
        for (WorldObjectView v : worldObjects) {
           I=imageMap.get(v.getClass()).getImage();
           size =imageMap.get(v.getClass()).getSize();
            g.drawImage(I, v.getPosition().x, v.getPosition().y,size.x,size.y,null); // see javadoc for more info on the parameters
        }
    }
    private void initializeHashmap(){
        imageMap.put(Volvo240.class,new ImageWithSize("/Volvo240.jpg",new Volvo240().getSize()));
        imageMap.put(Saab95.class,new ImageWithSize("/Saab95.jpg",new Saab95().getSize()));
        imageMap.put(LamborghiniGallardo.class,new ImageWithSize("/LamborghiniGallardo.jpg",new LamborghiniGallardo().getSize()));
        imageMap.put(Scania.class,new ImageWithSize("/Scania.jpg",new Scania().getSize()));
        imageMap.put(CarTransport.class,new ImageWithSize("/Cartransport.jpg",new CarTransport().getSize()));
        imageMap.put(CarFerry.class,new ImageWithSize("/CarFerry.jpg",new CarFerry().getSize()));
    }

    public <T> Point getSize(T obj){ return imageMap.get(obj.getClass()).getSize(); }

    public HashMap<Object, ImageWithSize> getImageMap() { return imageMap; }
}
