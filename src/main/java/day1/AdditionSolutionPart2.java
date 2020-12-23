package day1;

import java.util.Arrays;

public class AdditionSolutionPart2 {

    private int totalToFind = 2020;

    public long solution(String[] lines) {

        int[] array = Arrays.stream(lines)
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();

        int[] result = findIndexes(array);

        long product = result[0] * result[1] * result[2];

        return product;
    }

    private int[] findIndexes(int[] array) {

        int arraySize = array.length;
        int[] result = new int[3];

        for (int i = 0; i < arraySize - 2; i++) {

            int leftSideIndex = i + 1;
            int rightSideIndex = arraySize - 1;

            while (leftSideIndex < rightSideIndex) {

                if (array[i] + array[leftSideIndex] + array[rightSideIndex] == totalToFind) {
                    result[0] = array[i];
                    result[1] = array[leftSideIndex];
                    result[2] = array[rightSideIndex];

                    return result;
                }

                //if sum is too low then move up to higher values
                else if (array[i] + array[leftSideIndex] + array[rightSideIndex] < totalToFind) {
                    leftSideIndex++;
                } else {
                    //it is too big so move down to smaller numbers
                    rightSideIndex--;
                }
            }
        }
        return null;
    }
}
