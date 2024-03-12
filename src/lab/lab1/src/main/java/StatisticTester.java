package lab.lab1.src.main.java;

public class StatisticTester implements Tester {

    String sequence;
    public StatisticTester(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public void test() {
        long length = sequence.length();
        long sumOfOnes = 0;
        for (int i = 0; i<length; i++) {
            if (sequence.charAt(i)=='1') {
                sumOfOnes++;
            }
        }
        if(sumOfOnes > 9725 && sumOfOnes < 10275) {
            System.out.println("Liczba jedynek: "+sumOfOnes);
            String result = "Test pojedynczych bitów zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
        else {
            System.out.println("Liczba jedynek: "+sumOfOnes);
            String result = "Test pojedynczych bitów niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
    }
}
