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

        return result;

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

    private int findDistinctChars(String input) {

        ArrayList<Object> collect = input.replace("\n", "").chars().sorted().distinct().collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::add
        );

        return collect.size();
    }

    private boolean checkAllLettersAreRepeated(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (chars[i] != chars[0]) {
                return false;
            }
        }

        return true;
    }

    public List<String> findUniqueLetters(String s) {
        return s.chars().distinct().map(c ->(char)c).mapToObj(c -> String.valueOf(c)).collect(toList());
    }
}
