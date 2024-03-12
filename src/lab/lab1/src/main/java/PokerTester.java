package lab.lab1.src.main.java;

public class PokerTester implements Tester{

    String sequence;
    public PokerTester(String sequence) {
        this.sequence = sequence;
    }

    // Zamiana ciagu czterech bitow na liczbe dziesietna
    private int seqToInt(String sequence) {
        int result = 0;
        for(int i = 0; i<4; i++) {
            if(sequence.charAt(i)=='1')
                result += 8/(Math.pow(2,i));
        }
        return result;
    }


    @Override
    public void test() {
        int length = sequence.length();

        // Inicjalizacja tablicy
        int[] combinationCounts = new int[16];
        for(int i = 0; i<16; i++)
            combinationCounts[i] = 0;

        // Zliczanie wystapien różnych ciagow bitow
        for(int i = 0; i<length; i+=4) {
            String currentSequence = sequence.substring(i,i+4);
            combinationCounts[seqToInt(currentSequence)]++;
        }

        // Liczenie sumy kwadratow liczb wystapien poszczegolnych ciagow
        double sumSquared = 0;
        for(int i = 0; i<16; i++) {
            sumSquared += combinationCounts[i]*combinationCounts[i];
        }

        // Parametr testowany
        double x = (16.0/5000.0)*sumSquared-5000.0;

        // Cośki do printowania
        String lineBreak = "-".repeat(58);
        System.out.println("\nAnaliza wystąpień czwórek bitów:");
        System.out.println(lineBreak);
        System.out.printf("| %-30s || %-20s |%n","Ciąg (w systemie dziesiętnym)", "Liczba wystąpień");
        System.out.println(lineBreak);
        for (int i = 0; i<16; i++){
            System.out.printf("| %-30d || %-20d |%n",i, combinationCounts[i]);
        }
        System.out.println(lineBreak);
        System.out.println("\nWartość X:");
        System.out.println(x);

        if(x>2.16 && x<46.17) {
            String result = "Test pokerowy zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
        else {
            String result = "Test pokerowy niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
    }
}
