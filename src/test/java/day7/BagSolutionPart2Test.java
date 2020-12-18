package day7;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class BagSolutionPart2Test {

    @Test
    public void testPart2() {
        String testInput = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.";

        BagSolutionPart2 bagSolution = new BagSolutionPart2(testInput);
        int result = bagSolution.solutionPart2("shiny gold bag");
        assertEquals(32, result);
    }

    @Test
    public void testPart2WithInput() throws IOException {
        String path = "src/test/resources/day7input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        BagSolutionPart2 bagSolution2 = new BagSolutionPart2(contentOfFile);
        int result = bagSolution2.solutionPart2("shiny gold bag");
        assertEquals(6006, result);
    }
}
