package lab.lab6;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PhotoReader {
    BufferedImage encodedImg;
    public PhotoReader(String path) throws IOException {
        encodedImg = ImageIO.read(new File(path));
    }

    public String readLastBits() {
        StringBuilder stringBuilder = new StringBuilder();
        int[] pixels = encodedImg.getRGB(0,0,encodedImg.getWidth(),encodedImg.getHeight(),null,0,encodedImg.getWidth());
        for(int p : pixels) {
            int b = p & 0xff;
            int g = (p >> 8) & 0xff;
            int r = (p >> 16) & 0xff;
            stringBuilder.append(b%2);
            stringBuilder.append(g%2);
            stringBuilder.append(r%2);
        }
        String outputBits = stringBuilder.toString();
        StringBuilder output = new StringBuilder();
        for(int i = 0; i<outputBits.length()-8; i+=8) {
            String letter = Character.toString(Integer.parseInt(outputBits.substring(i,i+8),2));
            output.append(letter);
        }
        return output.toString();
    }
}
