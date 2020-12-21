package day9;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class SolutionPart1Test {

    @Test
    public void testFromSample() {
        String input = "35\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "47\n" +
            "40\n" +
            "62\n" +
            "55\n" +
            "65\n" +
            "95\n" +
            "102\n" +
            "117\n" +
            "150\n" +
            "182\n" +
            "127\n" +
            "219\n" +
            "299\n" +
            "277\n" +
            "309\n" +
            "576";

        String[] lines = input.split("\n");

        long[] array = new long[25];

        for (int i=0; i<lines.length; i++) {
            long number = Long.valueOf(lines[i]);
            array[i] = number;
        }

        SolutionPart1 solutionPart1 = new SolutionPart1();

        long result = solutionPart1.solution(array, 5);

        assertEquals(127, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day9input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        long[] array = new long[1000];

        for (int i=0; i<lines.length; i++) {
            long number = Long.valueOf(lines[i]);
            array[i] = number;
        }

        SolutionPart1 solutionPart1 = new SolutionPart1();
        long result = solutionPart1.solution(array, 25);

        //507622668
        System.out.println("result = " + result);
        assertEquals(507622668, result);
    }
}


