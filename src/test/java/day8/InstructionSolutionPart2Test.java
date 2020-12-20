package day8;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class InstructionSolutionPart2Test {

    @Test
    public void testWithSample() {
        String input = "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";

        InstructionSolutionPart2 instructionSolutionPart2 = new InstructionSolutionPart2();
        int result = instructionSolutionPart2.solution(input);

        assertEquals(result, 8);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day8input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        InstructionSolutionPart2 instructionSolutionPart2 = new InstructionSolutionPart2();
        int result = instructionSolutionPart2.solution(contentOfFile);

        System.out.println("result = " + result);
    }
}
