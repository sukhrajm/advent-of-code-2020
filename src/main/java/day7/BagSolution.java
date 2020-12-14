package day7;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BagSolution {

    private Multimap<String, String> allBags = ArrayListMultimap.create();

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
                    innerBagName = null;
                }
                else if (s.endsWith("s") || s.endsWith("s.")) {
                    innerBagName = s.substring(2, s.lastIndexOf("s"));
                }
                else if (s.endsWith(".")){
                    innerBagName = s.substring(2, s.lastIndexOf("."));
                }
                else {
                    innerBagName = s.substring(2);
                }

                allBags.put(outerBag, innerBagName);
            }
        }
    }

    int count = 0;
    public int solution(String innerBagDesc) {


        List<String> directParents = allBags.entries()
            .stream()
            .filter(f -> f.getValue() != null)
            .filter(f -> f.getValue().equals(innerBagDesc))
            .map(m -> m.getKey())
            .collect(toList());

        count = directParents.size();

        return find(directParents);

    }

    private int find(List<String> nodes) {

        List<String> parents = null;
        for (String n : nodes) {
            parents = allBags.entries()
                .stream()
                .filter(f -> f.getValue() != null)
                .filter(f -> f.getValue().equals(n))
                .map(m -> m.getKey())
                .collect(toList());

            count = count + parents.size();

        }

        if (parents.size() == 0) {
            return count;
        } else {
            return find(parents);
        }

    }
}
