package lab.lab5;

import lab.Helper;

import java.util.ArrayList;
import java.util.Random;

public class ShamirGenerator {
    private int t;
    private int n;
    private int s;
    private int p;

    private Random random = new Random();
    private ArrayList<Integer> coefficients;
    private int coefficientSize;

    private ArrayList<Share> shares;
    public ShamirGenerator(int t, int n, int s, int p) throws TooFewSharesException {
        if(t>n) {
            throw new TooFewSharesException("Number of required shares is greater that the number of generated ones");
        }
        else {
            this.t = t;
            this.n = n;
            this.s = s;
            this.p = (int) Helper.makePrime(p);
            System.out.println(this.p);
            System.out.println();

            coefficients = new ArrayList<>();
            shares = new ArrayList<>();

            for(int i = 0; i<(t-1); i++) {
                coefficients.add(random.nextInt(1000)+100);
            }
            coefficientSize = coefficients.size();
            for(int i = 1; i<=n; i++) {
                shares.add(new Share(i,calculateShare(i)));
            }
        }
    }

    private int calculateShare(int x) {
        int sum = 0;
        for(int i = 0; i<coefficientSize; i++) {
            sum += coefficients.get(i)*Math.pow(x,(double) coefficientSize-i);
        }
        sum+=s;
        sum = sum%p;
        return sum;
    }
    public ArrayList<Integer> getCoefficients() {
        return coefficients;
    }
    public ArrayList<Share> getShares() {
        return shares;
    }
    public int getN() {
        return n;
    }
    public int getP() {
        return p;
    }
    public int getS() {
        return s;
    }
    public int getT() {
        return t;
    }
}
