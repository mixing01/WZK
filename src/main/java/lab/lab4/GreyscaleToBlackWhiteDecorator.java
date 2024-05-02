package lab.lab4;

import java.awt.image.BufferedImage;

import static java.lang.Math.floor;

public class GreyscaleToBlackWhiteDecorator extends ImageDecorator{

    public GreyscaleToBlackWhiteDecorator(BufferedImage img) {
        super(img);
    }
    @Override
    public BufferedImage decorate() {
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels  = img.getRGB(0,0,width,height,null,0,width);
        int cutValue = (int) floor(255*0.5);
        for (int i = 0; i<pixels.length; i++) {
            int pixel = pixels[i];
            int b = pixel & 0xff;
            int g = (pixel >> 8) & 0xff;
            int r = (pixel >> 16) & 0xff;
            double avg = (b+g+r)/3.0;
            if(avg>cutValue) {
                pixels[i] = WHITE_PIXEL;
            }
            else {
                pixels[i] = BLACK_PIXEL;
            }
        }
        img.setRGB(0,0,width,height,pixels,0,width);
        return img;
    }
}
