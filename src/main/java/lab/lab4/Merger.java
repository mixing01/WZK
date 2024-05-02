package lab.lab4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Merger {

    private Merger() {}

    public static BufferedImage merge(BufferedImage img1, BufferedImage img2) {
        BufferedImage merged = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = merged.getGraphics();
        g.drawImage(img1,0,0,null);
        g.drawImage(img2,0,0,null);
        g.dispose();
        return merged;
    }
}
