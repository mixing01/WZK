package lab.lab1;

public class PokerTester implements Tester{
    private final int[] combinationCounts = new int[16];
    String sequence;
    double x;
    public PokerTester(String sequence) {
        this.sequence = sequence;
        int length = sequence.length();

        // Inicjalizacja tablicy
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
        x = (16.0/5000.0)*sumSquared-5000.0;
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
    public boolean test() {
        return (x>2.16 && x<46.17);
    }

    @Override
    public void printResults() {
        for(int i = 0; i<16; i++) {
            System.out.println(String.format("%04d", Integer.valueOf(Integer.toBinaryString(i)))+": "+combinationCounts[i]);
        }
        System.out.println("Zmienna testowa x (test pokerowy): "+x);
        if(x>2.16 && x<46.17) {
            String result = "Test pokerowy zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n" + border);
            System.out.println(result);
            System.out.println(border + "\n");
        }
        else {
            String result = "Test pokerowy niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n" + border);
            System.out.println(result);
            System.out.println(border + "\n");
        }

    }

    public int[] getCombinationCounts() {
        return combinationCounts;
    }
}
