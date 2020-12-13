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


}
