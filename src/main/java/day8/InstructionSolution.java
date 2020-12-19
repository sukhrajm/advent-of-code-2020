package day8;

import java.util.ArrayList;
import java.util.List;

public class InstructionSolution {

    int result = 0;

    public int solution(String input) {

        String[] lines = input.split("\n");

        List<Integer> visitedIndexes = new ArrayList<>();

        for (int i=0; i<lines.length; i++) {

            String line = lines[i];

            //when we visited any line more than once, return variable
            if (visitedIndexes.contains(i)) {
                return result;
            } else {
                //add to visited
                visitedIndexes.add(i);

                //the process the line
                if (line.startsWith("acc")) {
                    processAcc(line);
                } else if (line.startsWith("nop")) {
                    continue;
                } else if (line.startsWith("jmp")) {
                    int jumps = processJumps(line);
                    i = i + jumps;
                }
            }

        }

        return result;
    }

    private int processJumps(String line) {

        String instruction = line.substring(4);

        if (instruction.startsWith("+")) {
            String number = instruction.substring(1);
            int intNumber = Integer.valueOf(number);
            return intNumber - 1;
        }
        else if(instruction.startsWith("-")) {
            String number = instruction.substring(1);
            int intNumber = Integer.valueOf(number);
            return 0 - intNumber - 1;
        }

        return 0;
    }

    private void processAcc(String line) {

        String instruction = line.substring(4);

        if (instruction.startsWith("+")) {
            String number = instruction.substring(1);
            int intNumber = Integer.valueOf(number);
            result = result + intNumber;
        }
        else if(instruction.startsWith("-")) {
            String number = instruction.substring(1);
            int intNumber = Integer.valueOf(number);
            result = result - intNumber;
        }
    }
}
