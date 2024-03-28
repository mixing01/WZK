package lab.lab2;

import lab.Helper;

public class Keygen {
    private long p;
    private long q;
    private long e;

    private long d;
    private final long n;

    public Keygen(long p0, long q0, int digits) {
        p = p0;
        q = q0;

        e = (long) Math.floor(Math.random()*Math.pow(10,digits));
        d = (long) Math.floor(Math.random()*Math.pow(10,digits));

        long phi;

        while(Helper.isComposite(p)) {
            p++;
        }
        while(Helper.isComposite(q)) {
            q++;
        }

        n = p*q;
        phi = (p-1)*(q-1);

        while(!Helper.areCoprime(e,phi)) {
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

    public long getP() {
        return p;
    }

    public long getQ() {
        return q;
    }
}
