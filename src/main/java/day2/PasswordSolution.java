package day2;

public class PasswordSolution {

    public int solution(String[] lines) {

        int validLines = 0;

        for (String line : lines) {

            //1-3 a: abcde
            String[] parts = line.split(" ");

            String[] minMax = parts[0].split("-");
            int minOccurances = Integer.valueOf(minMax[0]);
            int maxOccurances = Integer.valueOf(minMax[1]);

            String letterToFind = parts[1].replace(":","");

            String stringToCheck = parts[2];

            char[] charArray = stringToCheck.toCharArray();

            int count = 0;

            for (int i=0; i<charArray.length; i++) {

                char current = charArray[i];

                if (current == letterToFind.charAt(0)) {
                    count++;
                }
            }

            if (count <= maxOccurances && count >= minOccurances) {
                validLines++;
            }

            System.out.println("count " + count);
            System.out.println("validLines " + line);
        }

        return validLines;
    }
}
