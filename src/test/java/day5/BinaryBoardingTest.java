package day5;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryBoardingTest {

    @Test
    public void testSolution() {
        String input = "FBFBBFFRLR";
        BinaryBoarding binaryBoarding = new BinaryBoarding();
        int result = binaryBoarding.solution(input);
        assertEquals(357, result);

    }

    @Test
    public void testFindResultFromInputFile() throws IOException {

        String path = "src/test/resources/day5input.txt";
        File file = new File(path);
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));) {

            String line;

            while ((line = br.readLine()) != null) {

                int tempResult = binaryBoarding.solution(line);

                if (tempResult > result) {
                    result = tempResult;
                }

            }
        }

        assertEquals(933, result);

    }

    @Test
    public void testFindResultFromInputFilePart2() throws IOException {

        String path = "src/test/resources/day5input.txt";
        File file = new File(path);
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        List<Integer> results = new ArrayList<>();
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            new FileInputStream(file), StandardCharsets.UTF_8));) {

            String line;

            while ((line = br.readLine()) != null) {

                int tempResult = binaryBoarding.solution(line);
                results.add(tempResult);

                sum = sum + tempResult;
            }
        }

        Collections.sort(results);
        int value = 0;
        int current = 0;

        for (Integer i : results) {

            //find where there is a gap of 2
            if (i - current == 2) {
                //the value missing will be 1 less than what we have
                value = i - 1;
                //System.out.println("value = " + value);
            }

            current = i;
        }

        assertEquals(711, value);
    }

    @Test
    public void testFindGap() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);

        int value = 0;

        int current = 0;
        for (Integer i : list) {

            if (i - current == 2) {
                value = i - 1;
            }

            current = i;
        }

        assertEquals(3, value);
    }
}
