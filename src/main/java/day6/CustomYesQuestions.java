package day6;

public class CustomYesQuestions {

    public long solution(String input) {

        long totalForGroup = 0;

        long totalForAllGroups = 0;

        String[] groups = input.split("\n\n");

        for(String group : groups) {
            totalForGroup = 0;
            String groupWithoutLines = removeNewLines(group);
            long uniqueChars = findUniqueLetters(groupWithoutLines);
            totalForGroup = totalForGroup + uniqueChars;

            totalForAllGroups = totalForAllGroups + totalForGroup;
        }

        return totalForAllGroups;
    }

    private String removeNewLines(String s) {
        return s.replace("\n", "");
    }

    private long findUniqueLetters(String s) {
        return s.chars().distinct().count();
    }


}
