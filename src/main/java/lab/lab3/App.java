package lab.lab3;
// lawinowosc zmian
// 3 pliki - 1MB, 3MB i 10MB

// 48% - 52% zmian bitów wyjścia przy zmianie jednego bitu wejścia
import lab.Helper;
public class App {

    private static void printStats(Hasher hasher, String one, String three, String ten) {
        System.out.println("Lista funkcji, czasów wykonania oraz długości ciągów wyjściowych dla plików 1MB, 3MB oraz 10MB");
        // Funkcje
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(Helper.functionNames.get(function)+", ");
        }
        System.out.println();
        for (HashFunctions function:
                HashFunctions.values()) {
            hasher.hash(function, one).getHashingTime();
        }
        System.out.println();
        // Czasy 1MB
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, one).getHashingTime()+", ");
        }
        System.out.println();
        // Czasy 3MB
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, three).getHashingTime()+", ");
        }
        System.out.println();
        // Czasy 10MB
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, ten).getHashingTime()+", ");
        }
        System.out.println();
        // Dlugosci ciagow wejsciowych
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, one).getHashedTextLength()+", ");
        }
        System.out.println();
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, three).getHashedTextLength()+", ");
        }
        System.out.println();
        for (HashFunctions function:
                HashFunctions.values()) {
            System.out.print(hasher.hash(function, ten).getHashedTextLength()+", ");
        }
    }
    public static void main(String[] args) {
        Hasher hasher = new Hasher();

        String one = Helper.generateBytes(1000000);
        String three = Helper.generateBytes(3000000);
        String ten = Helper.generateBytes(10000000);
        printStats(hasher, one, three, ten);

        // MD5 i krotkie haslo
        System.out.println("\n\nKrótki tekst - test funkcji MD5");
        HashResult md5short = hasher.hashHex(HashFunctions.MD5,"hej");
        System.out.println("Tekst oryginalny: "+md5short.getOriginalText());
        System.out.println("Efekt funkcji skrótu: "+md5short.getHashedText());



        HashFunctions[] testedFunctions = {HashFunctions.MD5, HashFunctions.SHA1,HashFunctions.SHA2_256, HashFunctions.SHA3_256};

        // Kolizje
        String collisionTest = "Garmazeryjne wyroby krakowskie";
        int[] bitsNumbers = {5,7,10,12,15,20};
        int collisionCounter = 0;
        System.out.println("\nTest kolizji dla ciągu: "+collisionTest);
        System.out.println();
        for(HashFunctions collisionFunction : testedFunctions) {
            System.out.println("Funkcja "+Helper.functionNames.get(collisionFunction));
            String testedHash = hasher.hash(collisionFunction,collisionTest).toString();
            for(int numberOfCollisionBits : bitsNumbers) {
                for(int i = 0; i<10000; i++) {
                    String randomText = Helper.generateBytes(100);
                    String temp = hasher.hash(collisionFunction, randomText).toString();
                    if(Helper.checkCollisionsOnNFirstBits(testedHash,temp,numberOfCollisionBits)) {
                        collisionCounter++;
                    }
                }
                System.out.println("Liczba kolizji na pierwszych "+numberOfCollisionBits+" bitach: "+collisionCounter);
                collisionCounter = 0;
            }
            System.out.println();
        }

        // SAC
        String sac1 = "Trombocyty w osoczu";
        String sac2 = Helper.swapOneBit(sac1);
        System.out.println("Test SAC - dwa łańcuchy znaków: \""+sac1+"\" oraz \""+sac2+"\"");
        for (HashFunctions function: testedFunctions) {
            System.out.println();
            System.out.println("Test SAC - funkcja "+Helper.functionNames.get(function));
            String res1 = hasher.hash(function,sac1).toString();
            String res2 = hasher.hash(function,sac2).toString();
            String xor = Helper.xor(res1,res2);
            System.out.println("Skrót 1: "+res1);
            System.out.println("Skrót 2: "+res2);
            System.out.println("Bitowy XOR: "+xor);
            System.out.println("Procent zmian: "+(double) xor.replace("0","").length()/(double)xor.length()*100+"%");
        }


    }
}
