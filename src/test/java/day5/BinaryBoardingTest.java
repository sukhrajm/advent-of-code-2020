package day5;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
}
