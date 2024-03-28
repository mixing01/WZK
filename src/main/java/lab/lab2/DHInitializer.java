package lab.lab2;

import lab.Helper;

import java.util.Random;

public class DHInitializer {
    private long n;
    private long g;

    public DHInitializer() {
        Random random = new Random();
        n = random.nextLong(1000,10000);
        g = random.nextLong(10,100);

        n = Helper.makePrime(n);

        while (!Helper.isPrimitiveRoot(g,n))
            g++;

        System.out.println("Liczba n: "+n);
        System.out.println("Liczba g: "+g);
    }

    public long getN() {
        return n;
    }
    public long getG() {
        return g;
    }
}
