package lab.lab4;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.nio.StreamingGifWriter;
import com.sksamuel.scrimage.nio.StreamingGifWriter.GifStream;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.List;

public class Giffer {

    private Giffer(){}
    public static void createGif(List<BufferedImage> images, String path) throws Exception {
        StreamingGifWriter writer = new StreamingGifWriter(Duration.ofSeconds(1), true, false);
        GifStream gif = writer.prepareStream(path + "/gif.gif", BufferedImage.TYPE_INT_ARGB);
        for (BufferedImage img : images) {
            gif.writeFrame(ImmutableImage.fromAwt(img));
        }
        gif.close();
    }

}
