package lab.lab3;

import java.util.List;

public class HashPrinter {
    private void printTitle(HashResult hashResult) {
        String name = "Funkcja skrótu: "+hashResult.getHashFunction();
        String border = "=".repeat(name.length());
        System.out.println(border);
        System.out.println(name);
        System.out.println(border);
        System.out.println();
    }
    private void printContent(HashResult hashResult) {
        System.out.println("Tekst oryginalny: "+hashResult.getOriginalText());
        System.out.println("Efekt funkcji skrótu: "+hashResult.getHashedText());
        System.out.println("Długość tekstu wyjściowego: "+hashResult.getHashedTextLength());
        System.out.println("Czas działania funkcji skrótu: "+hashResult.getHashingTime()+"ns");
    }

    public void print(HashResult hashResult) {
        printTitle(hashResult);
        printContent(hashResult);
    }

    public void print(List<HashResult> listOfResults) {
        if(!listOfResults.isEmpty()) {
            printTitle(listOfResults.get(0));
            for (HashResult hashResult:
                 listOfResults) {
                printContent(hashResult);
                System.out.println();
            }
        }
    }
}
