package day7;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

import java.util.*;

public class BagSolution {

    private MutableGraph<String> allBags = GraphBuilder.directed().build();

    BagSolution(String rules) {

        String[] lines = rules.split("\n");

        for (String line : lines) {

            String[] parts = line.split("contain ");

            //remove the 's' to get the singular name
            String outerBag = parts[0].substring(0, parts[0].length() - 2);

            //parts[1] might have comma separated list of inner bags
            String[] innerBagStrings = parts[1].split(",");

            for (String s : innerBagStrings) {
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

                allBags.putEdge(innerBagName, outerBag);
            }
        }
    }

    public int solution(String innerBagDesc) {

        int val = find(allBags, innerBagDesc, new HashSet<>()) - 1;
        return val;

    }

    private int find(MutableGraph<String> bags, String node, Set<String> visitedNodes) {

        //we have already visited this node, so ignore it
        if (visitedNodes.contains(node)) {
            //System.out.println("node has not been visited: " + node);
            return 0;
        } else {
            //else add it
           // System.out.println("node has been visited: " + node);
            visitedNodes.add(node);
        }

        int count = 1;

        for (String parent : bags.successors(node)) {
            //System.out.println("parent in loop: " + node);
            count += find(bags, parent, visitedNodes);
        }

        return count;
    }
}
