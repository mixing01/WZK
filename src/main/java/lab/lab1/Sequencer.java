package lab.lab1;

import lab.Helper;

public class Sequencer {
    private final long n;
    private long x;

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

        while(Helper.isComposite(p)) {
            p+=4;
        }
        while(Helper.isComposite(q)) {
            q+=4;
        }

        n = p * q;
        while(!Helper.areCoprime(x, n)) {
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
