package lab.lab2;

import java.math.BigInteger;

public class App {

    private static void lab21() {
        Keygen keygen = new Keygen(1351, 5422, 2);
        Encryptor encryptor = new Encryptor(keygen.getE(), keygen.getD(), keygen.getN());

        System.out.println("p: "+ keygen.getP());
        System.out.println("q: "+ keygen.getQ());
        System.out.println("e: "+ keygen.getE());
        System.out.println("d: "+ keygen.getD());
        System.out.println("n: "+ keygen.getN());
        System.out.println();
        System.out.println("Treść niezaszyfrowanej wiadomości:");
        String message = "Niezaszyfrowana wiadomosc, calkiem fajna";
        System.out.println(message);
        BigInteger[] encrypted = encryptor.encrypt(message);
        System.out.println("\nZaszyfrowana wiadomość");
        for (BigInteger elem:
             encrypted) {
            System.out.print(elem.longValue()+" ");
        }
        System.out.println("\n\nOdszyfrowana wiadomość");
        System.out.println(encryptor.decrypt(encrypted));
    }

    private static void lab22() {
        DHInitializer dhInitializer = new DHInitializer();
        DHUser user1 = new DHUser(dhInitializer);
        DHUser user2 = new DHUser(dhInitializer);
        user1.sendKey(user2);
        user2.sendKey(user1);

        user1.calculateSessionKey();
        user2.calculateSessionKey();

        System.out.println("Klucz sesji ustalony przez użytkownika nr 1: "+user1.getSessionKey());
        System.out.println("Klucz sesji ustalony przez użytkownika nr 2: "+user2.getSessionKey());

    }
    public static void main(String[] args) {
        String header = "Zadanie 2.1.";
        String border = "=".repeat(header.length());
        System.out.println("\n"+border);
        System.out.println(header);
        System.out.println(border+"\n");
        lab21();

        header = "Zadanie 2.2.";
        border = "=".repeat(header.length());
        System.out.println("\n"+border);
        System.out.println(header);
        System.out.println(border+"\n");
        lab22();
    }
}
