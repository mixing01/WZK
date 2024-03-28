package lab.lab1;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Sequencer sequencer = new Sequencer(1530,6891, 4739);
        String sequence = sequencer.generate(20000);

        StatisticTester statisticTester = new StatisticTester(sequence);
        SequenceTester sequenceTester = new SequenceTester(sequence);
        LongSequenceTester longSequenceTester = new LongSequenceTester(sequence);
        PokerTester pokerTester = new PokerTester(sequence);

        ArrayList<Tester> testerList = new ArrayList<>();
        testerList.add(statisticTester);
        testerList.add(sequenceTester);
        testerList.add(longSequenceTester);
        testerList.add(pokerTester);

        System.out.println("Wygenerowany ciąg:");
        System.out.println(sequence+"\n");
        for (Tester tester:
             testerList) {
            tester.test();
            tester.printResults();
        }
    }
}
