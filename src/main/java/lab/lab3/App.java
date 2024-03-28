package lab.lab3;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Hasher hasher = new Hasher();
        HashPrinter hashPrinter = new HashPrinter();
        ArrayList<String> textList = new ArrayList<>();
        textList.add("Kot");
        textList.add("Pancernik");
        textList.add("Kou");
        textList.add("Konstantynopol");
        textList.add("Bagietka");
        textList.add("Brzoza");
        textList.add("Aspartam");

        hashPrinter.print(hasher.hash(HashFuntions.SHA2_512_224, "ABC"));
        System.out.println("\n");
        for (HashFuntions function:
             HashFuntions.values()) {
            hashPrinter.print(hasher.hash(function, textList));
            System.out.println();
        }
    }
}
