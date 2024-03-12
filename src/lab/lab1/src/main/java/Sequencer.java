package lab.lab1.src.main.java;

public class Sequencer {
    private final long n;
    private long x;

    private boolean czyPierwsza(long a) {
        for(int i = 2; i<=Math.sqrt(a); i++) {
            if (a%i==0) {
                return false;
            }
        }
        return true;
    }
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
    public Sequencer(long p0, long q0, long x0) {
        long p = p0;
        long q = q0;
        x = x0;

        // Spełnienie warunku przystawania
        while(p %4 != 3) {
            p++;
        }
        while(q %4 != 3) {
            q++;
        }

        boolean pprime = czyPierwsza(p);
        boolean qprime = czyPierwsza(q);

        while(!pprime) {
            p +=4;
            pprime = czyPierwsza(p);
        }

        while(!qprime) {
            q +=4;
            qprime = czyPierwsza(q);
        }

        n = p * q;
        while(!czyWzgledniePierwsze(x, n)) {
            x+=1;
        }
    }

    public String generate(long length) {
        StringBuilder sequence = new StringBuilder();
        long xi = (x*x)% n;
        for (int i = 0; i<length; i++) {
            xi = (xi*xi)% n;
            String binaryString = Long.toBinaryString(xi);
            char b = binaryString.charAt(binaryString.length()-1);
            sequence.append(b);
        }
        return sequence.toString();
    }
}
