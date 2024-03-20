package lab.lab2.src.main.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class DHInitializer {

    private long nwd(long a, long b) {
        while(a!=b) {
            if (a>b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    private boolean czyWzgledniePierwsze(long a, long b) {
        return nwd(a, b)==1;
    }

    private long n;
    private long g;

    private boolean czyZlozona(long a) {
        for(int i = 2; i<=Math.sqrt(a); i++) {
            if (a%i==0) {
                return true;
            }
        }
        return false;
    }

    private  boolean czyPierwiastekPierwotny(long a, long modulo) {
        ArrayList<BigInteger> reszty = new ArrayList<>();
        for(long i = 1; i<modulo; i++) {
            if(czyWzgledniePierwsze(i,modulo) && (!reszty.contains(BigInteger.valueOf(i)))) {
                reszty.add(BigInteger.valueOf(i));
            }
        }
        BigInteger firstModulo = BigInteger.valueOf(a%modulo);
        BigInteger currentModulo = firstModulo;
        BigInteger number = BigInteger.valueOf(a);
        BigInteger mod = BigInteger.valueOf(modulo);
        long power = 2;
        do {
            reszty.remove(currentModulo);
            currentModulo = number.modPow(BigInteger.valueOf(power),mod);
            power++;
        } while(currentModulo.compareTo(firstModulo)!=0);

        return reszty.isEmpty();
    }

    public DHInitializer() {
        Random random = new Random();
        n = random.nextLong(1000,10000);
        g = random.nextLong(10,100);

        while (czyZlozona(n))
            n++;

        while (!czyPierwiastekPierwotny(g,n))
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
