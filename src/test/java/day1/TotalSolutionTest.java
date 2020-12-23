package day1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class TotalSolutionTest {

    @Test
    public void testWithSample() {
        String input = "1721\n" +
            "979\n" +
            "366\n" +
            "299\n" +
            "675\n" +
            "1456";

        String[] lines = input.split("\n");
        TotalSolution totalSolution = new TotalSolution();

        //1721 and 299 multiplied together
        int result = totalSolution.solution(lines);

        assertEquals(514579, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day1input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        TotalSolution totalSolution = new TotalSolution();

        int result = totalSolution.solution(lines);

        System.out.println("result = " + result);
        assertEquals(471019, result);
    }
}
