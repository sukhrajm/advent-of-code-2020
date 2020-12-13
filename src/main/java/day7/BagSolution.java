package day7;

import java.util.ArrayList;
import java.util.List;

public class BagSolution {

    List<Bag> allBags = new ArrayList<>();

    int countForRecursion = 0;

    BagSolution(String rules) {

        String[] parts = rules.split("contain ");

        //remove the 's' to get the singular name
        String outerBag = parts[0].substring(0, parts[0].length() - 1);

        //parts[1] might have comma separated list of inner bags
        String innerBag = parts[1].substring(0, parts[1].length() - 1);

        String[] innerBagStrings = innerBag.split(",");
        List<Bag> innerBags = new ArrayList<>();
        if (innerBagStrings.length > 0) {

            for (String desc : innerBagStrings) {
                Bag b = new Bag(desc, null);
                innerBags.add(b);
            }
            Bag bag = new Bag(outerBag, innerBags);
            allBags.add(bag);
        } else {
            Bag bag = new Bag(outerBag, createInnerBags(new Bag(innerBag, null)));
            allBags.add(bag);
        }





    }

    public int solution(String innerBagDesc) {

        int count = 0;

        for (Bag b : allBags) {

            count = find(b, innerBagDesc);
        }

        return count;
    }



    private int find(Bag b, String desc) {

        if (b.inner != null) {

            for (Bag b1 : b.inner) {
                if (b1.description.contains(desc)) {
                    countForRecursion++;
                } else {
                    find(b1, desc);
                }
            }
        }

        return countForRecursion;

    }

    private List<Bag> createInnerBags(Bag... bags) {

        List<Bag> result = new ArrayList<>();

        for(Bag b : bags) {
            result.add(b);
        }

        return result;
    }
}
