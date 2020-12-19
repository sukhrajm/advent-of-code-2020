package day8;

import day7.BagSolutionPart2;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class InstructionSolutionTest {

    @Test
    public void testSample() {

        String input = "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";


        InstructionSolution instructionSolution = new InstructionSolution();
        int result = instructionSolution.solution(input);
        assertEquals(5, result);

    }

    @Test
    public void testWithInput() throws IOException {
        String path = "src/test/resources/day8input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        InstructionSolution instructionSolution = new InstructionSolution();
        int result = instructionSolution.solution(contentOfFile);

        System.out.println("result = " + result);
        assertEquals(1521, result);
    }
}
