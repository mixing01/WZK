package lab.lab3;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Hasher {
    public HashResult hash(HashFuntions function, String text) {
        String result;
        long start;
        long finish;
        long diff;
        HashResult hashResult = null;
        switch (function) {
            case MD5 -> {
                start = System.nanoTime();
                result = DigestUtils.md5Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("MD5", text, result, diff);
            }
            case SHA1 -> {
                start = System.nanoTime();
                result = DigestUtils.sha1Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA1", text, result, diff);
            }
            case SHA2_256 -> {
                start = System.nanoTime();
                result = DigestUtils.sha256Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA2-256", text, result, diff);
            }
            case SHA2_384 -> {
                start = System.nanoTime();
                result = DigestUtils.sha384Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA2-384", text, result, diff);
            }
            case SHA2_512 -> {
                start = System.nanoTime();
                result = DigestUtils.sha512Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA2-512", text, result, diff);
            }
            case SHA2_512_224 -> {
                start = System.nanoTime();
                result = DigestUtils.sha512_224Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA2-512/224", text, result, diff);
            }
            case SHA2_512_256 -> {
                start = System.nanoTime();
                result = DigestUtils.sha512_256Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA2-512/256", text, result, diff);
            }
            case SHA3_224 -> {
                start = System.nanoTime();
                result = DigestUtils.sha3_224Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA3-224", text, result, diff);
            }
            case SHA3_256 -> {
                start = System.nanoTime();
                result = DigestUtils.sha3_256Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA3-256", text, result, diff);
            }
            case SHA3_512 -> {
                start = System.nanoTime();
                result = DigestUtils.sha3_512Hex(text);
                finish = System.nanoTime();
                diff = finish - start;
                hashResult = new HashResult("SHA3-512", text, result, diff);
            }
        }
        return hashResult;
    }

    public List<HashResult> hash(HashFuntions function, List<String> textList) {
        String result;
        ArrayList<HashResult> listOfResults = new ArrayList<>();
        long start;
        long finish;
        long diff;
        switch (function) {
            case MD5 -> {
                for (String text:
                     textList) {
                    start = System.nanoTime();
                    result = DigestUtils.md5Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("MD5", text, result, diff));
                }
                

            }
            case SHA1 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha1Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA1", text, result, diff));
                }
                
            }
            case SHA2_256 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha256Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA2-256", text, result, diff));
                }

            }
            case SHA2_384 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha384Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA2-384", text, result, diff));
                }

            }
            case SHA2_512 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha512Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA2-512", text, result, diff));
                }

            }
            case SHA2_512_224 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha512_224Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA2-512/224", text, result, diff));
                }

            }
            case SHA2_512_256 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha512_256Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA2-512/256", text, result, diff));
                }

            }
            case SHA3_224 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha3_224Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA3-224", text, result, diff));
                }

            }
            case SHA3_256 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha3_256Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA3-256", text, result, diff));
                }

            }
            case SHA3_512 -> {
                for (String text:
                        textList) {
                    start = System.nanoTime();
                    result = DigestUtils.sha3_512Hex(text);
                    finish = System.nanoTime();
                    diff = finish - start;
                    listOfResults.add(new HashResult("SHA3-512", text, result, diff));
                }
            }

        }
        return listOfResults;
    }
}
