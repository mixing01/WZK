package lab.lab4;
// ECB, CBC & CTR
// Nie robić OFB i CFB

// Propagacja błędów - Uszkodzenie wiadomości i uszkodzenie szyfrogramu


import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String generatedText = "Tajne hasło";
        String imgPath = "src/main/java/lab/lab4/res";
        ImageFromTextGenerator imageFromTextGenerator = new ImageFromTextGenerator();
        BufferedImage img = imageFromTextGenerator.nextBufferedImage(generatedText);
        GreyscaleToBlackWhiteDecorator greyscale = new GreyscaleToBlackWhiteDecorator(img);
        img = greyscale.decorate();
        UpscaleDecorator upscale = new UpscaleDecorator(img);
        BufferedImage upscaled = upscale.decorate();
        ImageSaver.saveBufferedImageAs(upscaled, imgPath, "original.png");
        SharesGenerator sharesGenerator = new SharesGenerator();
        ArrayList<BufferedImage> shares = new ArrayList<>(sharesGenerator.generateShares(img, upscaled));
        ImageSaver.saveBufferedImagesAs(shares, imgPath);
        BufferedImage merged = Merger.merge(shares.get(0), shares.get(1));
        ImageSaver.saveBufferedImageAs(merged, imgPath, "merged.png");

        ArrayList<BufferedImage> imagesForGif = new ArrayList<>();
        imagesForGif.add(shares.get(0));
        imagesForGif.add(shares.get(1));
        imagesForGif.add(merged);
        Giffer.createGif(imagesForGif, imgPath);
    }
}

