package lab.lab5;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws TooFewSharesException {
        ShamirGenerator generator = new ShamirGenerator(3, 5,690,10810);
        ArrayList<Share> shares = generator.getShares();
        ArrayList<Share> usedShares = new ArrayList<>();
        System.out.println("Użyte p: "+generator.getP());
        System.out.println("Wygenerowane udziały:");
        for (Share s : shares) {
            System.out.println(s);
        }
        usedShares.add(shares.get(0));
        usedShares.add(shares.get(2));
        usedShares.add(shares.get(3));
        System.out.println("Odzyskany sekret: "+ShamirReader.recoverSecret(usedShares,generator.getP()));
    }
}
