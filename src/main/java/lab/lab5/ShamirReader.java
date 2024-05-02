package lab.lab5;

import java.math.BigInteger;
import java.util.List;

public class ShamirReader {
    private ShamirReader() {}

    public static int recoverSecret(List<Share> shares, int p) {
        int sum = 0;
        for(Share si: shares) {
            sum += (calculateConstant(shares, si, p));
            sum = sum%p;
        }
        return sum;
    }

    private static int calculateConstant(List<Share> shares, Share si, int p) {
        BigInteger numerator = BigInteger.valueOf(1);
        BigInteger denominator = BigInteger.valueOf(1);
        for(Share share : shares) {
            if(share.getShareIndex() != si.getShareIndex()) {
                numerator = numerator.multiply(BigInteger.valueOf((-1)*share.getShareIndex()));
                denominator = denominator.multiply(BigInteger.valueOf(si.getShareIndex()-share.getShareIndex()));
            }

        }
        BigInteger resultBigInt = numerator.divide(denominator).multiply(BigInteger.valueOf(si.getShareValue()));
        System.out.println(resultBigInt);
        while(resultBigInt.compareTo(BigInteger.ZERO) < 0) {
            resultBigInt = resultBigInt.add(BigInteger.valueOf(p));
        }
        resultBigInt = resultBigInt.mod(BigInteger.valueOf(p));
        System.out.println(resultBigInt);
        System.out.println();
        return resultBigInt.intValue();
    }
}
