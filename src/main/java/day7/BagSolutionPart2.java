package day7;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import org.apache.commons.lang3.tuple.Pair;

public class BagSolutionPart2 {

    MutableGraph<Pair<Integer,String>> allBags = GraphBuilder.directed().build();

    BagSolutionPart2(String rules) {

        String[] lines = rules.split("\n");

        for (String line : lines) {

            String[] parts = line.split("contain ");

            //remove the 's' to get the singular name
            String outerBag = parts[0].substring(0, parts[0].length() - 2);

            //parts[1] might have comma separated list of inner bags
            String[] innerBagStrings = parts[1].split(",");

            for (String s : innerBagStrings) {

                int quantity = getQuantity(s);

                String innerBagName = null;
                if (s.equals("no other bags.")) {
                    innerBagName = "";
                }
                else if (s.endsWith("s") || s.endsWith("s.")) {
                    innerBagName = s.substring(2, s.lastIndexOf("s")).stripLeading();
                }
                else if (s.endsWith(".")){
                    innerBagName = s.substring(2, s.lastIndexOf(".")).stripLeading();
                }
                else {
                    innerBagName = s.substring(2).stripLeading();
                }
                allBags.putEdge(Pair.of(quantity,innerBagName), Pair.of(1,outerBag));
            }
        }
    }

    public int solutionPart2(String innerBagDesc) {

        Graph<Pair<Integer,String>> allBags2 = Graphs.transpose(allBags);

        int val = findForPartTwo(allBags2, Pair.of(1, innerBagDesc));

        return val - 1;
    }

    private int findForPartTwo(Graph<Pair<Integer,String>> bags, Pair<Integer,String> node) {

        int count = 1;

        for (Pair<Integer,String> child : bags.successors(node)) {

            if (child.getLeft() != 0) {

                int quantity = child.getLeft();

                int result = quantity * findForPartTwo(bags, Pair.of(1, child.getRight()));

                count += result;
            }
        }

        return count;
    }

    private Integer getQuantity(String node) {

        String newString = node.stripLeading();

        int numberOfNodes = 0;
        if(Character.isDigit(newString.charAt(0))) {
            String amount = newString.substring(0, newString.indexOf(" "));
            numberOfNodes = Integer.valueOf(amount);
        }
        return numberOfNodes;
    }
}
