package day2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class PasswordSolutionPart2Test {

    @Test
    public void testWithSample() {
        String input = "1-3 a: abcde\n" +
            "1-3 b: cdefg\n" +
            "2-9 c: ccccccccc";

        String[] lines = input.split("\n");

        PasswordSolutionPart2 passwordSolutionPart2 = new PasswordSolutionPart2();
        int result = passwordSolutionPart2.solution(lines);
        assertEquals(1, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day2input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        PasswordSolutionPart2 passwordSolutionPart2 = new PasswordSolutionPart2();
        int result = passwordSolutionPart2.solution(lines);
        System.out.println("result = " + result);
    }
}
