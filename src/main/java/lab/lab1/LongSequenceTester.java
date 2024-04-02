package lab.lab1;

public class LongSequenceTester implements Tester {
    String sequence;
    int length;
    private int maxSeqLen = 1;
    public LongSequenceTester(String sequence) {
        this.sequence = sequence;
        this.length = sequence.length();
    }
    @Override
    public boolean test() {
        maxSeqLen = 1;
        int tempSeqLen = 1;
        for(int i = 1; i<length; i++) { // Dla każdego bitu
            if (sequence.charAt(i - 1) == sequence.charAt(i)) { // Jeśli jest on zerem...
                tempSeqLen++;
            }
            else {
                if (tempSeqLen>maxSeqLen)
                    maxSeqLen=tempSeqLen;
                tempSeqLen = 1;
            }
        }
        return (maxSeqLen<=25);
    }

    @Override
    public void printResults() {
        System.out.println("Najdłuższy ciąg tych samych bitow ma dlugosc "+maxSeqLen);
        if(maxSeqLen<=25){
            String result = "Test dlugiej serii zaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
        else {
            String result = "Test długiej serii niezaliczony";
            String border = "=".repeat(result.length());
            System.out.println("\n"+border);
            System.out.println(result);
            System.out.println(border+"\n");
        }
    }

    public int getMaxSeqLen() {
        return maxSeqLen;
    }
}
