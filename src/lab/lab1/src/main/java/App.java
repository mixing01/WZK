package lab.lab1.src.main.java;

public class App {

    public static void main(String[] args) {
        Sequencer sequencer = new Sequencer(1363,6891, 4739);
        String sequence = sequencer.generate(20000);

        StatisticTester statisticTester = new StatisticTester(sequence);
        SequenceTester sequenceTester = new SequenceTester(sequence);
        PokerTester pokerTester = new PokerTester(sequence);

        System.out.println("Wygenerowany ciąg:");
        System.out.println(sequence+"\n");
        statisticTester.test();
        sequenceTester.test();
        pokerTester.test();

    }
}
