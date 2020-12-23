package day10;

import java.util.*;
import java.util.stream.Collectors;

public class PlugAdaptorSolution {

    public int solution(String[] lines) {

        List<Integer> integers = Arrays.stream(lines)
            .map(Integer::valueOf)
            .sorted()
            .collect(Collectors.toList());

//        integers.stream().forEach(System.out::println);

        int oneDiffTotals = 0;
        int threeDiffTotals = 0;

        int index = 0;
        while(index != integers.size() - 1) {

            //get the diff between each line

            int current = integers.get(index);
//            System.out.println("current value = " + current);

            int next = integers.get(index + 1);
//            System.out.println("next value = " + next);

            int diff = next - current;

            if (diff == 1) {
                oneDiffTotals++;
            }

            if (diff == 3) {
                threeDiffTotals++;
            }
            index++;
        }

        oneDiffTotals++;
        threeDiffTotals++;
        System.out.println("1 diffs total = " + oneDiffTotals);
        System.out.println("3 diffs total = " + threeDiffTotals);

        return oneDiffTotals * threeDiffTotals;
    }
}
