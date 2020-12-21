package day9;

import java.util.Arrays;

public class SolutionPart1 {

    public long solution(long[] array, int preamble) {

        for (int i=preamble; i<array.length; i++) {

            long[] subArray = Arrays.copyOfRange(array, i-preamble, i);

            boolean canMakeSum = canMakeSum(subArray, array[i]);
            if (!canMakeSum) {
                return array[i];
            }
        }

        return 0;
    }

    private boolean canMakeSum(long[] numbers, long total) {

        Arrays.sort(numbers);

        int index = 0;
        int size = numbers.length - 1;

        while (index < size) {

            //index and the end item sum to make total
            if (numbers[index] + numbers[size] == total) {
                return true;
            }
            //if it is less, move the index up one to bigger values
            else if (numbers[index] + numbers[size] < total) {
                index++;
            }

            //if it more, then move down from the end, to smaller values
            else {
                size--;
            }
        }
        return false;
    }
}
