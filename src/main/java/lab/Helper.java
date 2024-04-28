package lab;

import lab.lab3.HashFunctions;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.util.*;

public class Helper {
    static Random random = new Random();
    public static final Map<HashFunctions, String> functionNames = new EnumMap<>(HashFunctions.class);
    static {
        functionNames.put(HashFunctions.MD5, "MD5");
        functionNames.put(HashFunctions.SHA1, "SHA1");
        functionNames.put(HashFunctions.SHA2_256, "SHA2-256");
        functionNames.put(HashFunctions.SHA2_384, "SHA2-384");
        functionNames.put(HashFunctions.SHA2_512, "SHA2-512");
        functionNames.put(HashFunctions.SHA2_512_224, "SHA2-512/224");
        functionNames.put(HashFunctions.SHA2_512_256, "SHA2-512/256");
        functionNames.put(HashFunctions.SHA3_224, "SHA3-224");
        functionNames.put(HashFunctions.SHA3_256, "SHA3-256");
        functionNames.put(HashFunctions.SHA3_512, "SHA3-512");
    }
    private Helper(){}

    public static int clamp(int number, int min, int max) {
        if(number<min) {
            return clamp(number + min, min, max);
        }
        if (number > max) {
            return clamp(number - max, min, max);
        }
        return number;
    }
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

    public static String generateBytes(int length) {
        byte[] bytes = new byte[length];
        StringBuilder builder = new StringBuilder();
        random.nextBytes(bytes);
        for(int i = 0; i<length; i++) {
            builder.append((char) clamp(bytes[i],32,126));
        }
        return builder.toString();
    }

    public static byte[] hash(String text, HashFunctions function) {
        switch (function) {
            case MD5 -> {
                return DigestUtils.md5(text);
            }
            case SHA1 -> {
                return DigestUtils.sha1(text);
            }
            case SHA2_256 -> {
                return DigestUtils.sha256(text);
            }
            case SHA2_384 -> {
                return DigestUtils.sha384(text);
            }
            case SHA2_512 -> {
                return DigestUtils.sha512(text);
            }
            case SHA2_512_224 -> {
                return DigestUtils.sha512_224(text);
            }
            case SHA2_512_256 -> {
                return DigestUtils.sha512_256(text);
            }
            case SHA3_224 -> {
                return DigestUtils.sha3_224(text);
            }
            case SHA3_256 -> {
                return DigestUtils.sha3_256(text);
            }
            case SHA3_512 -> {
                return DigestUtils.sha3_512(text);
            }
        }
        return new byte[0];
    }

    public static String hashHex(String text, HashFunctions function) {
        switch (function) {
            case MD5 -> {
                return DigestUtils.md5Hex(text);
            }
            case SHA1 -> {
                return DigestUtils.sha1Hex(text);
            }
            case SHA2_256 -> {
                return DigestUtils.sha256Hex(text);
            }
            case SHA2_384 -> {
                return DigestUtils.sha384Hex(text);
            }
            case SHA2_512 -> {
                return DigestUtils.sha512Hex(text);
            }
            case SHA2_512_224 -> {
                return DigestUtils.sha512_224Hex(text);
            }
            case SHA2_512_256 -> {
                return DigestUtils.sha512_256Hex(text);
            }
            case SHA3_224 -> {
                return DigestUtils.sha3_224Hex(text);
            }
            case SHA3_256 -> {
                return DigestUtils.sha3_256Hex(text);
            }
            case SHA3_512 -> {
                return DigestUtils.sha3_512Hex(text);
            }
        }
        return "";
    }

    public static String swapOneBit(String text){
        int length = text.length();
        int swappedCharIndex = random.nextInt(length-1);
        char character = text.charAt(swappedCharIndex);
        if(character % 2 == 0)
            character++;
        else
            character--;
        if(swappedCharIndex==length-1)
            return text.substring(0,swappedCharIndex) + character;
        else
            return text.substring(0,swappedCharIndex) + character + text.substring(swappedCharIndex+1);
    }

    public static String xor(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int length = s1.length();
        for(int i = 0; i<length; i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                result.append('1');
            }
            else {
                result.append('0');
            }
        }
        return result.toString();
    }

    public static String convertStringToBinary(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            result.append(String.format("%8s", Integer.toBinaryString(c)).replace(" ", "0"));
        }
        return result.toString();

    }
    public static boolean checkCollisionsOnNFirstBits(String s1bin, String s2bin, int n) {
        boolean isCollision = true;
        for(int i = 0; i<n; i++) {
            if(s1bin.charAt(i)!=s2bin.charAt(i)) {
                isCollision = false;
                break;
            }
        }
        return isCollision;
    }
}
