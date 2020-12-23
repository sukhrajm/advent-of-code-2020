package day1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class AdditionSolutionPart2Test {

    @Test
    public void testWithSample() {
        String input = "1721\n" +
            "979\n" +
            "366\n" +
            "299\n" +
            "675\n" +
            "1456";

        String[] lines = input.split("\n");

        AdditionSolutionPart2 additionSolutionPart2 = new AdditionSolutionPart2();
        long result = additionSolutionPart2.solution(lines);
        assertEquals(241861950, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day1input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        AdditionSolutionPart2 additionSolutionPart2 = new AdditionSolutionPart2();

        long result = additionSolutionPart2.solution(lines);

        System.out.println("result = " + result);
    }
}
