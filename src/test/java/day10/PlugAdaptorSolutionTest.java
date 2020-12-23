package day10;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class PlugAdaptorSolutionTest {

    @Test
    public void testWithSample() {
        String input = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

        String[] lines = input.split("\n");

        PlugAdaptorSolution plugAdaptorSolution = new PlugAdaptorSolution();
        int result = plugAdaptorSolution.solution(lines);

        //22 differences of 1 jolt and 10 differences of 3 jolts, multiplied together
        assertEquals(220, result);


    }

    @Test
    public void testWithFile() throws IOException {

        String path = "src/test/resources/day10input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        PlugAdaptorSolution plugAdaptorSolution = new PlugAdaptorSolution();

        int result = plugAdaptorSolution.solution(lines);

        System.out.println("result = " + result);
    }
}
