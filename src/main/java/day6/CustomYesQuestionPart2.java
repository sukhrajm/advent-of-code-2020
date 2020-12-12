package day6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CustomYesQuestionPart2 {


    private CustomYesQuestions customYesQuestions = new CustomYesQuestions();


    public int solution(String input) {

        String[] groups = input.split("\n\n");

        int total = 0;

        for (String group : groups) {
            int commonLettersInOneGroup = findNumberOfCommonLetters(group);
            total = total + commonLettersInOneGroup;
        }

        return total;

    }

    private int findNumberOfCommonLetters(String input) {
        Map<Character, Integer> map = new HashMap<>();

        String[] lines = input.split("\n");
        int numberOfNewLines = lines.length;

        String input2 = input.replace("\n", "");

        char[] array = input2.toCharArray();

        for (char c : array) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                Integer i = map.get(c);
                i++;
                map.put(c, i);
            }
        }

        List<Character> commonChars = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == numberOfNewLines) {
                //the this character appeared on each line
                commonChars.add(entry.getKey());
            }
        }

        return commonChars.size();

    }

}
