package day9;

import java.util.Arrays;

public class SolutionPart2 {

    public long solution(long total, long[] array) {
        int[] indexes = findToAndFromIndex(total, array);

        int from = indexes[0];
        int to = indexes[1];

        long[] subArray = new long[to - from + 1];

        int index = 0;
        for (int i=from; i<=to; i++) {
            subArray[index] = array[i];
            index++;
        }

        //add together smallest and largest in subarray


        Arrays.sort(subArray);
        long result = subArray[0] + subArray[subArray.length - 1];

        return result;
    }


    private int[] findToAndFromIndex(long total, long[] array) {

        int[] result = new int[2];

        for (int i=0; i<array.length; i++) {

            long currentSum = 0;

            currentSum = currentSum + array[i];

            for (int j=i+1; j<array.length; j++) {

               if (currentSum == total) {
                   //if we have found the sum, store the to and from index
                   result[0] = i;
                   result[1] = j - 1;
                   return result;
               }
               else if(currentSum > total) {
                   //move the outer index up 1 so get out of this inner loop
                   break;
               }

               currentSum = currentSum + array[j];
            }
        }


        return null;
    }

}
