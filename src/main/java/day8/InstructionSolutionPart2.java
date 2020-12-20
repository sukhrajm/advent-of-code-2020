package day8;

import java.util.ArrayList;
import java.util.List;

public class InstructionSolutionPart2 {

    private int result = 0;

    public int solution(String input) {

        String[] originalLines = input.split("\n");

        String[] lines = input.split("\n");

        boolean replacement = false;

        boolean isInfiniteRun = isInfiniteRun(originalLines);

        int indexOfReplacement = 0;
        String instructionBeforeReplacement = "";

        List<Integer> indexesThatHaveBeenReplaced = new ArrayList<>();

        while(isInfiniteRun) {

            if (replacement) {
                //reset the instruction of the replacement if it has happened
                lines[indexOfReplacement] = instructionBeforeReplacement;
                replacement = false;
                result = 0;
            }

            for (int i=0; i<lines.length; i++) {

                //we are only replacing 1 at a time
                if (replacement) {
                    break;
                }

                String line = lines[i];

                if (!hasSeenIndex(indexesThatHaveBeenReplaced, i) && line.startsWith("jmp") && !indexesThatHaveBeenReplaced.contains(i)) {
                    //change to nop
                    instructionBeforeReplacement = line;
                    String newLine = line.replace("jmp", "nop");
                    lines[i] = newLine;
                    replacement = true;
                    indexOfReplacement = i;
                    indexesThatHaveBeenReplaced.add(i);

                } else if (!hasSeenIndex(indexesThatHaveBeenReplaced, i) && line.startsWith("nop") && !indexesThatHaveBeenReplaced.contains(i)) {
                    //change to jmp
                    instructionBeforeReplacement = line;
                    String newLine = line.replace("nop", "jmp");
                    lines[i] = newLine;
                    replacement = true;
                    indexOfReplacement = i;
                    indexesThatHaveBeenReplaced.add(i);
                }
            }

            isInfiniteRun = isInfiniteRun(lines);
        }

        return result;
    }

    private boolean hasSeenIndex(List<Integer> list, int i) {

        //if it is in the list then we have seen the index
        if (list.contains(i)) {
            return true;
        }

        //if list is empty then we have not seen this index before
        if (list.isEmpty()) {
            return false;
        }

        //just return that we have not seen the index
        return false;
    }

    private boolean isInfiniteRun(String[] lines) {

        List<Integer> visitedIndexes = new ArrayList<>();

        for (int i=0; i<lines.length; i++) {

            String line = lines[i];

            //when we visited any line more than once, return variable
            if (visitedIndexes.contains(i)) {
                return true;
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

        return false;


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
