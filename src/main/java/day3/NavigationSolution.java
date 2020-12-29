package day3;

public class NavigationSolution {

    public int solution(String[] lines, int y, int x) {

        char[][] grid = new char[y][x];

        for(int i=0; i<lines.length; i++) {

            String line = lines[i];

            char[] charsInLine = line.toCharArray();

            for(int j=0; j<charsInLine.length; j++) {

                grid[i][j] = charsInLine[j];
            }
        }

        int xSlope = 3;
        int ySlope = 1;

        int xIndex = 0;
        int yIndex = 0;

        int treeCount = 0;

        while (yIndex < grid.length) {

            char current = grid[yIndex][xIndex];
         //   System.out.println("char = " + current);

            yIndex = yIndex + ySlope;

            int xindexsum = xIndex + xSlope;

            if (xindexsum >= x) {
                xIndex = xindexsum - x;
            } else {
                xIndex = xindexsum;
            }

            //this is more simpler to use than the above if/else
           // xIndex = xindexsum % 31;
           //  System.out.println(xindexsum + " % 31 = " + xIndex);

            if (current == '#') {
                treeCount++;
            }
        }

        return treeCount;
    }
}
