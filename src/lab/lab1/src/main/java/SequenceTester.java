package lab.lab1.src.main.java;

public class SequenceTester implements Tester{

    String sequence;
    int length;
    // Dolne granice testu serii dla sekwencji o długościach 1, 2, 3, 4, 5 oraz 6 i więcej
    private final int[] lowerBounds = {2315,1114,527,240,103,103};

    // Gorne granice testu serii dla sekwencji o długościach 1, 2, 3, 4, 5 oraz 6 i więcej
    private final int[] upperBounds = {2685,1386,723,384,209,209};

    // Liczba wystąpień sekwencji zer o długościach 1, 2, 3, 4, 5 oraz 6 i więcej
    private final int[] zeroSequences = {0,0,0,0,0,0};

    // Liczba wystąpień sekwencji jedynek o długościach 1, 2, 3, 4, 5 oraz 6 i więcej
    private final int[] oneSequences = {0,0,0,0,0,0};

    // Pomocnicza zmienna - dlugosc obecnie sprawdzanego nieprzerwanego ciagu jedynek
    private int oneSeqLen = 1;

    // Pomocnicza zmienna - dlugosc obecnie sprawdzanego nieprzerwanego ciagu zer
    private int zeroSeqLen = 1;

    // Pomocnicza zmienna - dlugosc najdluzszej serii tych samych bitow
    int maxSeqLen = 1;

    public SequenceTester(String sequence) {
        this.sequence = sequence;
        this.length = sequence.length();
    }

    private void testSequences() {
        for(int i = 1; i<length; i++) { // Dla każdego bitu
            if(sequence.charAt(i)=='0') { // Jeśli jest on zerem...
                testSequenceZeros(i);
            }
            else { // Jeśli jest on jedynką...
                testSequenceOnes(i);
            }
        }
        // Zapisanie dlugosci ostatniej serii wystepujacej w sekwencji
        if(sequence.charAt(length-1)=='0') {
            if (zeroSeqLen > 6)
                zeroSequences[5]++;
            else
                zeroSequences[zeroSeqLen-1]++;
        }
        else {
            if (oneSeqLen > 6)
                oneSequences[5]++;
            else
                oneSequences[oneSeqLen-1]++;
        }
    }
    private void testSequenceZeros(int i) {
        if(sequence.charAt(i-1)==sequence.charAt(i)) { // Jesli poprzedni bit taki sam
            zeroSeqLen++; // Zwieksz licznik nieprzerwanej dlugosci serii zer
        } else { // Jesli przerwano sekwencje to zapisz wynik w odpowiednim miejscu w tabeli
            if (zeroSeqLen > 6)
                zeroSequences[5]++;
            else
                zeroSequences[zeroSeqLen-1]++;
            zeroSeqLen = 1;
        }

        if (zeroSeqLen > maxSeqLen)
            maxSeqLen = zeroSeqLen; // Zapisuj najdluzsza dotychczasowa serie tych samych bitow
    }

    private void testSequenceOnes(int i) {
            if(sequence.charAt(i-1)==sequence.charAt(i)) { // Jesli poprzedni bit taki sam
                oneSeqLen++; // Zwieksz licznik nieprzerwanej dlugosci serii jedynek
            } else { // Jesli przerwano sekwencje to zapisz wynik w odpowiednim miejscu w tabeli
                if (oneSeqLen > 6)
                    oneSequences[5]++;
                else
                    oneSequences[oneSeqLen-1]++;
                oneSeqLen = 1;
            }

        if(oneSeqLen > maxSeqLen)
            maxSeqLen = oneSeqLen; // Zapisuj najdluzsza dotychczasowa serie tych samych bitow
    }

    @Override
    public void test() {

        // Zmienna okreslajaca, czy sekwencja zdala test serii
        boolean shortTest = true;

        // Zmienna okreslajaca, czy sekwencja zdala test dlugiej serii
        boolean longTest = true;

        testSequences();

        if (maxSeqLen>25) {
            longTest = false;
        }

        // Sprawdzenie czy liczba wystapien serii miesci sie w odpowiednich przedzialach
        for(int i = 0; i<6; i++){
            if (!(zeroSequences[i] >= lowerBounds[i] && zeroSequences[i] <= upperBounds[i] &&
                    oneSequences[i] >= lowerBounds[i] && oneSequences[i] <= upperBounds[i])) {
                shortTest = false;
                break;
            }
        }



        // Moje dziwne cośki do ładnego wypisywania
        String lineBreak = "-".repeat(48);
        System.out.println("\nDla ciągów zer uzyskano następujące wyniki:");
        System.out.println(lineBreak);
        System.out.printf("| %-20s || %-20s |%n","Długość ciągu", "Liczba wystąpień");
        System.out.println(lineBreak);
        for (int i = 0; i<5; i++){
            System.out.printf("| %-20d || %-20d |%n",i+1, zeroSequences[i]);
        }
        System.out.println("| "+String.format("%-20s","6+")+" || "+String.format("%-20d",zeroSequences[5])+" |");
        System.out.println(lineBreak);

        System.out.println("\nDla ciągów jedynek uzyskano następujące wyniki:");
        System.out.println(lineBreak);
        System.out.printf("| %-20s || %-20s |%n","Długość ciągu", "Liczba wystąpień");
        System.out.println("------------------------------------------------");
        for (int i = 0; i<5; i++){
            System.out.printf("| %-20d || %-20d |%n",i+1, oneSequences[i]);
        }
        System.out.println("| "+String.format("%-20s","6+")+" || "+String.format("%-20d",oneSequences[5])+" |");
        System.out.println(lineBreak);

        if(shortTest){
            String result = "Test serii zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
        else {
            String result = "Test serii niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }

        System.out.println("Najdluzszy ciag tych samych bitow ma dlugosc "+maxSeqLen);
        if(longTest){
            String result = "Test dlugiej serii zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
        else {
            String result = "Test dlugiej serii niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
    }
}
