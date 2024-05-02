package lab.lab4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageSaver {

    private ImageSaver(){}

    public static void saveBufferedImageAs(BufferedImage img, String path, String name) {
        String filepath = path+"/"+name;
        try {
            ImageIO.write(img, "png", new File(filepath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveBufferedImagesAs(List<BufferedImage> images, String path) {
        int index = 1;
        for(BufferedImage img : images) {
            try {
                ImageIO.write(img, "png", new File(path+"/share"+index+".png"));
                index++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
