package day1;

import java.util.Arrays;

public class TotalSolution {

    private int totalToFind = 2020;

    private int[] result = new int[2];

    public int solution(String[] lines) {

        int[] array = Arrays.stream(lines)
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();

        int[] indexes = findTwoNumbers(array);

        int result = array[indexes[0]] * array[indexes[1]];

        return result;
    }


    private int[] findTwoNumbers(int[] array) {

        int index = 0;
        while (index != array.length - 1) {

            int current = array[index];

            for (int j=index + 1; j<array.length; j++) {

                int currentSum = current + array[j];

                if (currentSum == totalToFind) {
                    result[0] = index;
                    result[1] = j;
                }
            }

            index++;
        }

        return result;
    }

}
