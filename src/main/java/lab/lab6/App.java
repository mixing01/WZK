package lab.lab6;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        PhotoEncoder photoEncoder = new PhotoEncoder("src/main/java/lab/lab6/res/originalImg.png");
        photoEncoder.encodeMessage("Tajne haslo ukryte w obrazku, nikt by sie tego nie spodziewal, a jednak jest", "src/main/java/lab/lab6/res/newImg.png");
        PhotoReader photoReader = new PhotoReader("src/main/java/lab/lab6/res/newImg.png");
        String result = photoReader.readLastBits();
        System.out.println(result.substring(0,100));
    }
}
