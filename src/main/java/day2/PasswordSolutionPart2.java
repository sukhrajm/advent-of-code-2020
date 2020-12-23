package day2;

public class PasswordSolutionPart2 {

    public int solution(String[] lines) {

        int validLines = 0;

        for (String line : lines) {

            //1-3 a: abcde is valid: position 1 contains a and position 3 does not.
            String[] parts = line.split(" ");

            String[] minMax = parts[0].split("-");
            int first = Integer.valueOf(minMax[0]);
            int second = Integer.valueOf(minMax[1]);

            String letterToFind = parts[1].replace(":", "");
            char charToFind = letterToFind.charAt(0);

            String stringToCheck = parts[2];
            char[] charArray = stringToCheck.toCharArray();

            if (second > charArray.length) {
                continue;
            }

           // if (first < charArray.length && second < charArray.length) {
                if (charArray[first-1] == charToFind ^ charArray[second-1] == charToFind) {
                    //System.out.println("valid line is " + line);
                    validLines++;
                }
           // }

        }

        return validLines;
    }
}
