package lab.rest;

import lab.lab1.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(produces="application/json")
public class Controller {
    @GetMapping(path = "/test")
    public Map<String, String> test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test","test");
        return map;
    }
    @GetMapping("/lab1")
    public Map<String, String> lab1(@RequestParam long p0, @RequestParam long q0, @RequestParam long x0, @RequestParam long length) {
        HashMap<String, String> map = new HashMap<>();
        Sequencer sequencer = new Sequencer(p0, q0, x0);
        String sequence = sequencer.generate(length);
        StatisticTester statisticTester = new StatisticTester(sequence);
        SequenceTester sequenceTester = new SequenceTester(sequence);
        LongSequenceTester longSequenceTester = new LongSequenceTester(sequence);
        PokerTester pokerTester = new PokerTester(sequence);
        map.put("sequence",sequence);
        map.put("statisticTest",""+statisticTester.test());
        map.put("sequenceTest",""+sequenceTester.test());
        map.put("longSequenceTest",""+longSequenceTester.test());
        map.put("pokerTest",""+pokerTester.test());
        return map;
    }
}
