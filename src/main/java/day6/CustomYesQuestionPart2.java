package day6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CustomYesQuestionPart2 {


    private CustomYesQuestions customYesQuestions = new CustomYesQuestions();


    public long solution(String input) {

        int result = findNumberOfCommonLetters(input);

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

        String input2 = input.replace("\n", "");

        boolean hasNewLines = true;

        if (input2.equals(input)) {
            hasNewLines = false;
        }

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

        int max = Collections.max(map.values());

        int numberOfCharachtersOccuringMaxTimes = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                numberOfCharachtersOccuringMaxTimes++;
            }
        }


        if (hasNewLines) {
            if (numberOfCharachtersOccuringMaxTimes == input2.length()) {
                //then all the letters occured the same number of times so no common
                return 0;
            }
        }

        return numberOfCharachtersOccuringMaxTimes;

    }

}
