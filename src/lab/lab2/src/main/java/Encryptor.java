package lab.lab2.src.main.java;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class Encryptor {

    private long e;
    private long d;
    private long n;

    public Encryptor(long e, long d, long n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }
    public BigInteger[] encrypt(String message) {
        char[] letters = message.toCharArray();
        BigInteger[] result = new BigInteger[message.length()];
        for (int i = 0; i < message.length(); i++) {
            result[i] = BigInteger.valueOf(letters[i]).modPow(BigInteger.valueOf(e),BigInteger.valueOf(n));
        }
        return result;
    }

    public String decrypt(BigInteger[] letters) {
        StringBuilder result = new StringBuilder();
        for (BigInteger letter : letters) {
            result.append((char) letter.modPow(BigInteger.valueOf(d),BigInteger.valueOf(n)).intValue());
        }
        return result.toString();
    }
}
