package lab.lab4;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharesGenerator {
    private static final int WHITE_BYTE = Integer.parseInt("11111111",2);
    private static final int BLACK_BYTE = Integer.parseInt("00000000",2);
    private static final int BLACK_PIXEL = (WHITE_BYTE << 24) | (BLACK_BYTE << 16) | (BLACK_BYTE << 8) | BLACK_BYTE;
    private static final int WHITE_PIXEL = (BLACK_BYTE << 24) | (WHITE_BYTE << 16) | (WHITE_BYTE << 8) | WHITE_BYTE;

    int[][] horizontal1 = {{BLACK_PIXEL, BLACK_PIXEL},{WHITE_PIXEL,WHITE_PIXEL}};
    int[][] horizontal2 = {{WHITE_PIXEL,WHITE_PIXEL},{BLACK_PIXEL, BLACK_PIXEL}};
    int[][] vertical1 = {{BLACK_PIXEL, WHITE_PIXEL},{BLACK_PIXEL,WHITE_PIXEL}};
    int[][] vertical2 = {{WHITE_PIXEL, BLACK_PIXEL},{WHITE_PIXEL,BLACK_PIXEL}};
    int[][] diagonal1 = {{BLACK_PIXEL, WHITE_PIXEL},{WHITE_PIXEL,BLACK_PIXEL}};
    int[][] diagonal2 = {{WHITE_PIXEL, BLACK_PIXEL},{BLACK_PIXEL,WHITE_PIXEL}};

    int[][][] fragmentSet = {horizontal1, horizontal2, vertical1, vertical2, diagonal1, diagonal2};
    Random random;
    public SharesGenerator() {
        random = new Random();
    }
    public List<BufferedImage> generateShares(BufferedImage originalImg, BufferedImage upscaledImg) {
        int width = upscaledImg.getWidth();
        int height = upscaledImg.getHeight();
        int targetSize = width*height;
        int originalWidth = originalImg.getWidth();
        int originalHeight = originalImg.getHeight();
        int[] pixels  = originalImg.getRGB(0,0,originalWidth,originalHeight,null,0,originalWidth);
        int[][] pixels1 = new int[height][width];
        int[][] pixels2 = new int[height][width];
        int[] imgPixels1 = new int[targetSize];
        int[] imgPixels2 = new int[targetSize];
        for(int i = 0; i<originalHeight; i++) {
            for (int j = 0; j < originalWidth; j++) {
                int currentPixel = pixels[i*originalWidth+j];
                fragmentGenerator(2*i, 2*j,currentPixel, pixels1, pixels2);
            }
        }

        int counter = 0;
        for (int[] hp: pixels1) {
            for (int wp : hp) {
                imgPixels1[counter] = wp;
                counter++;
            }
        }

        counter = 0;
        for (int[] hp: pixels2) {
            for (int wp : hp) {
                imgPixels2[counter] = wp;
                counter++;
            }
        }
        BufferedImage share1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        BufferedImage share2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        share1.setRGB(0,0,width,height,imgPixels1,0,width);
        share2.setRGB(0,0,width,height,imgPixels2,0,width);
        ArrayList<BufferedImage> result = new ArrayList<>();
        result.add(share1);
        result.add(share2);
        return result;
    }

    private void fragmentGenerator(int i, int j, int pixel, int[][] pixels1, int[][] pixels2) {
        int randomChoice = random.nextInt(6);
        int choice1;
        int choice2;
        if(pixel == WHITE_PIXEL) {
            choice1 = randomChoice;
            choice2 = randomChoice;
        }
        else {
            choice1 = randomChoice;
            if(randomChoice%2==0) {
                choice2 = choice1++;
            }
            else{
                choice2 = choice1--;
            }
        }
        installFragment(pixels1, fragmentSet[choice1], i, j);
        installFragment(pixels2, fragmentSet[choice2], i, j);
    }

    private void installFragment(int[][] a, int[][] b, int i, int j) {
        a[i][j] = b[0][0];
        a[i][j+1] = b[0][1];
        a[i+1][j] = b[1][0];
        a[i+1][j+1] = b[1][1];
    }
}
