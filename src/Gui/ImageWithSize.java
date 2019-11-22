package Gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageWithSize {
    protected File file=new File("pics");
    protected String filePath= file.getAbsolutePath();
    private Image image;
    private Point size;

    public ImageWithSize(String picturePath, Point size) {
        setImage(picturePath);
        this.size = size;
    }

    public Image getImage() { return image; }

    private void setImage(String PicturePath) {
        try{this.image = ImageIO.read(new File(filePath+PicturePath));}
        catch (IOException e) { e.printStackTrace(); }
    }

    public Point getSize() {
        return size;
    }

}
