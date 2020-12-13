package day7;

import org.junit.Test;

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
            "black bags contain 1 shiny gold bag.";


        BagSolution bagSolution = new BagSolution(testInput);
        int result = bagSolution.solution("shiny gold bag");

        assertEquals(2, result);

    }

}
