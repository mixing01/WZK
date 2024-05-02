package lab.lab4;

import java.awt.image.BufferedImage;

public abstract class ImageDecorator {
    BufferedImage img;
    static final int WHITE_BYTE = Integer.parseInt("11111111",2);
    static final int BLACK_BYTE = Integer.parseInt("00000000",2);
    static final int BLACK_PIXEL = (WHITE_BYTE << 24) | (BLACK_BYTE << 16) | (BLACK_BYTE << 8) | BLACK_BYTE;
    static final int WHITE_PIXEL = (BLACK_BYTE << 24) | (WHITE_BYTE << 16) | (WHITE_BYTE << 8) | WHITE_BYTE;

    protected ImageDecorator(BufferedImage img) {
        this.img = img;
    }
    public BufferedImage decorate() {
        return img;
    }
}
