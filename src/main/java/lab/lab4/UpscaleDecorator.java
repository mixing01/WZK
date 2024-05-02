package lab.lab4;

import java.awt.image.BufferedImage;

public class UpscaleDecorator extends ImageDecorator {

    public UpscaleDecorator(BufferedImage img) {
        super(img);
    }
    @Override
    public BufferedImage decorate() {
        int width = img.getWidth();
        int height = img.getHeight();
        int newWidth = 2*width;
        int newHeight = 2*height;
        int[] pixels = img.getRGB(0,0,width,height,null,0,width);
        int[][] upscaledPixels = new int[newHeight][newWidth];
        int[] newPixels = new int[newHeight*newWidth];
        for(int i = 0; i<height; i++) {
            for (int j = 0; j < width; j++) {
                int currentPixel = pixels[i*width+j];
                upscaledPixels[2*i][2*j] = currentPixel;
                upscaledPixels[2*i][2*j+1] = currentPixel;
                upscaledPixels[2*i+1][2*j] = currentPixel;
                upscaledPixels[2*i+1][2*j+1] = currentPixel;
            }
        }
        int counter = 0;
        for (int[] hp: upscaledPixels) {
            for (int wp : hp) {
                newPixels[counter] = wp;
                counter++;
            }
        }
        BufferedImage newImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        newImg.setRGB(0,0,newWidth,newHeight,newPixels,0, newWidth);
        return newImg;
    }
}
