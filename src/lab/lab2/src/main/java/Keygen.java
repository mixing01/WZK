package lab.lab2.src.main.java;

public class Keygen {

    private long e;

    private long d;
    private  long n;

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


    private boolean czyZlozona(long a) {
        for(int i = 2; i<=Math.sqrt(a); i++) {
            if (a%i==0) {
                return true;
            }
        }
        return false;
    }

    public Keygen(long p0, long q0, int digits) {
        long p = p0;
        long q = q0;

        e = (long) Math.floor(Math.random()*Math.pow(10,digits));
        d = (long) Math.floor(Math.random()*Math.pow(10,digits));

        long phi;

        while(czyZlozona(p)) {
            p++;
        }
        while(czyZlozona(q)) {
            q++;
        }

        n = p*q;
        phi = (p-1)*(q-1);

        while(!czyWzgledniePierwsze(e,phi)) {
            e++;
        }
        while ((e*d)%phi!=1) {
            d++;
        }

    }

    public long getE() {
        return e;
    }

    public long getD() {
        return d;
    }

    public long getN() {
        return n;
    }
}
