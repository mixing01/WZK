package lab.rest;

import lab.lab1.*;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public String lab1(@RequestParam long p0, @RequestParam long q0, @RequestParam long x0, @RequestParam long length) {
        JSONObject jsonObject = new JSONObject();
        Sequencer sequencer = new Sequencer(p0, q0, x0);
        String sequence = sequencer.generate(length);
        StatisticTester statisticTester = new StatisticTester(sequence);
        SequenceTester sequenceTester = new SequenceTester(sequence);
        LongSequenceTester longSequenceTester = new LongSequenceTester(sequence);
        PokerTester pokerTester = new PokerTester(sequence);
        jsonObject.put("sequence",sequence);
        jsonObject.put("statisticTest",statisticTester.test());
        jsonObject.put("sumOfOnes",statisticTester.getSumOfOnes());
        jsonObject.put("sequenceTest",sequenceTester.test());
        jsonObject.put("zeroSequences",sequenceTester.getZeroSequences());
        jsonObject.put("oneSequences",sequenceTester.getOneSequences());
        jsonObject.put("longSequenceTest",longSequenceTester.test());
        jsonObject.put("maxSeqLen",longSequenceTester.getMaxSeqLen());
        jsonObject.put("pokerTest",pokerTester.test());
        jsonObject.put("combinationCounts",pokerTester.getCombinationCounts());
        return jsonObject.toString();
    }
}
