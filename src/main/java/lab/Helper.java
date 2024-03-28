package lab;

import java.math.BigInteger;
import java.util.ArrayList;

public class Helper {
    private Helper(){}
    public static boolean isComposite(long a) {
        for(int i = 2; i<=Math.sqrt(a); i++) {
            if (a%i==0) {
                return true;
            }
        }
        return false;
    }

    public static long gcd(long a, long b) {
        while(a!=b) {
            if (a>b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static boolean areCoprime(long a, long b) {
        return gcd(a, b)==1;
    }

    public static boolean isPrimitiveRoot(long a, long modulo) {
        ArrayList<BigInteger> remainders = new ArrayList<>();
        for(long i = 1; i<modulo; i++) {
            if(areCoprime(i,modulo) && (!remainders.contains(BigInteger.valueOf(i)))) {
                remainders.add(BigInteger.valueOf(i));
            }
        }
        BigInteger firstModulo = BigInteger.valueOf(a%modulo);
        BigInteger currentModulo = firstModulo;
        BigInteger number = BigInteger.valueOf(a);
        BigInteger mod = BigInteger.valueOf(modulo);
        long power = 2;
        do {
            remainders.remove(currentModulo);
            currentModulo = number.modPow(BigInteger.valueOf(power),mod);
            power++;
        } while(currentModulo.compareTo(firstModulo)!=0);

        return remainders.isEmpty();
    }

    public static long makePrime(long a) {
        if (a != 2) {
            if (a % 2 == 0)
                a++;
            while (isComposite(a)) {
                a += 2;
            }
        }
        return a;
    }
}
