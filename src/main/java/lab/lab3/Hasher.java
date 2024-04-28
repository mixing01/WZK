package lab.lab3;

import lab.Helper;

import java.util.ArrayList;
import java.util.List;

public class Hasher {
    public HashResult hashHex(HashFunctions function, String text) {
        String result;
        long start;
        long finish;
        long diff;
        HashResult hashResult;
        start = System.nanoTime();
        result = Helper.hashHex(text,function);
        finish = System.nanoTime();
        diff = finish - start;
        hashResult = new HashResult(Helper.functionNames.get(function), text, result, diff);
        return hashResult;
    }

    public List<HashResult> hashHex(HashFunctions function, List<String> textList) {
        String result;
        ArrayList<HashResult> listOfResults = new ArrayList<>();
        long start;
        long finish;
        long diff;
        for (String text:
                textList) {
            start = System.nanoTime();
            result = Helper.hashHex(text, function);
            finish = System.nanoTime();
            diff = finish - start;
            listOfResults.add(new HashResult(Helper.functionNames.get(function), text, result, diff));
        }
        return listOfResults;
    }

    public HashResult hash(HashFunctions function, String text) {
        StringBuilder result = new StringBuilder();
        long start;
        long finish;
        long diff;
        HashResult hashResult;
        start = System.nanoTime();
        byte[] temp = Helper.hash(text, function);
        for (byte i : temp) {
            result.append(String.format("%8s", Integer.toBinaryString(i & 0xFF)).replace(' ', '0'));
        }
        finish = System.nanoTime();
        diff = finish - start;
        hashResult = new HashResult(Helper.functionNames.get(function), text, result.toString(), diff);
        return hashResult;
    }

    public List<HashResult> hash(HashFunctions function, List<String> textList) {
        StringBuilder result;
        ArrayList<HashResult> listOfResults = new ArrayList<>();
        long start;
        long finish;
        long diff;
        for (String text: textList) {
            start = System.nanoTime();
            result = new StringBuilder();
            byte[] temp = Helper.hash(text,function);
            for (byte i : temp) {
                result.append(String.format("%8s", Integer.toBinaryString(i & 0xFF)).replace(' ', '0'));
            }
            finish = System.nanoTime();
            diff = finish - start;
            listOfResults.add(new HashResult(Helper.functionNames.get(function), text, result.toString(), diff));
        }
        return listOfResults;
    }

}
