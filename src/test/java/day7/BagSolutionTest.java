package day7;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class BagSolutionTest {

    private String testInput;

    @Test
    public void testOneBagCanHoldOneTargetBagDirectly() {

        testInput = "bright white bags contain 1 shiny gold bag.";

        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(1, result);

    }

    @Test
    public void testBagWithTwoInnerCanHoldOneTargetBagDirectly() {

        testInput = "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.";

        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(1, result);

    }

    @Test
    public void testBagWithMultipleTargetBagDirectly() {

        testInput = "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
                    "bright white bags contain 1 shiny gold bag.";


        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(2, result);

    }

    @Test
    public void testBagWithMultipleTargetBagsOneIsIndirect() {

        testInput = "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.";


        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(1, result);

    }

    @Test
    public void testBagWithMultipleTargetBagsTwoAreIndirect() {

        testInput = "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "bright blue bags contain 2 black bags.\n" +
            "spotty black bags contain 1 shiny gold bag.";


        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(2, result);

    }

   @Test
    public void testFromSample() {

        testInput = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.";

        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(4, result);

    }

    @Test
    public void testFromInputFile() throws IOException {

        String path = "src/test/resources/day7input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        BagSolution bagSolution = new BagSolution(contentOfFile);
        int result = bagSolution.solution("shiny gold bag");

        System.out.println("result = " + result);
    }

}
