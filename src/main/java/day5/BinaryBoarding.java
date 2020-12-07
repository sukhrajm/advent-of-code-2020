package day5;

public class BinaryBoarding {

    /**
     * B = upper half 		R = upper half
     * F = lower half 		L = lower half
     * @param input
     * @return
     */
    public int solution(String input) {

        Range currentRange = new Range(0, 127);

        char[] chars = input.toCharArray();

        //first 7 items are for the rows
        for (int i=0; i<chars.length-3; i++) {

            char c = chars[i];

            if (c == 'B') {
                //find upper half
                Range range = findUpperHalf(currentRange.start, currentRange.end);
                currentRange = range;

            } else if (c == 'F') {
                //find lower half
                Range range = findLowerHalf(currentRange.start, currentRange.end);
                currentRange = range;

            }
        }

        Range currentRangeForSeat = new Range(0, 7);
        //now find the seat ranges are 0-8
        for (int i=7; i<input.length(); i++) {

            char c = chars[i];

            if (c == 'R') {
                //find upper half
                Range range = findUpperHalf(currentRangeForSeat.start, currentRangeForSeat.end);
                currentRangeForSeat = range;

            } else {
                //must be L
                //find lower half
                Range range = findLowerHalf(currentRangeForSeat.start, currentRangeForSeat.end);
                currentRangeForSeat = range;
            }
        }

        //the final values of current range will be same, so just get either the start or end
        int finalRow = currentRange.start;

        int finalSeat = currentRangeForSeat.start;

        //make the seat id multiply the row by 8, then add the column
        int result = finalRow * 8 + finalSeat;

        return result;
    }

    private Range findUpperHalf(int start, int end) {

        int numberOfItems = end - start + 1;

        int halfOfItems = numberOfItems / 2;

        Range range = new Range(start + halfOfItems, end);

        return range;
    }

    private Range findLowerHalf(int start, int end) {

        int numberOfItems = end - start;

        if (start == 0) {
            numberOfItems = numberOfItems - 1;
        }

        int halfOfItems = numberOfItems / 2;

        Range range = new Range(start, (end - halfOfItems) - 1);

        return range;
    }
}
