package lab.lab6;

import lab.Helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PhotoEncoder {
    BufferedImage originalImg;
    public PhotoEncoder(String path) throws IOException {
        originalImg = ImageIO.read(new File(path));
    }

    public void encodeMessage(String message, String path) throws IOException {
        int[] pixels = originalImg.getRGB(0,0,originalImg.getWidth(),originalImg.getHeight(),null,0,originalImg.getWidth());
        String bin = Helper.convertStringToBinary(message);
        for(int i = 0; i<bin.length(); i++) {
            if(bin.charAt(i)=='0') {
                pixels[i/3] &= ~(1 << (8*(i%3)));
            }
            else {
                pixels[i/3] |= 1 << (8*(i%3));
            }
        }
        BufferedImage newImg = new BufferedImage(originalImg.getWidth(),originalImg.getHeight(),BufferedImage.TYPE_INT_ARGB);
        newImg.setRGB(0,0,originalImg.getWidth(),originalImg.getHeight(),pixels,0,originalImg.getWidth());
        ImageIO.write(newImg, "png", new File(path));
    }
}
