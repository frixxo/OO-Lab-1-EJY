package Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    protected File file=new File("pics");
    private String filePath= file.getAbsolutePath();
    private Image image;

    public ImageHandler(String picturePath) {
        setImage(picturePath);
    }

    private void setImage(String PicturePath) {
        try{this.image = ImageIO.read(new File(filePath+PicturePath));}
        catch (IOException e) { e.printStackTrace(); }
    }

    public Image getImage(){ return image;}

}
