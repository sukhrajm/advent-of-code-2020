package day3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class NavigationSolutionTest {

    @Test
    public void testWithSample() {
        String input =
            "..##.........##.........##.........##.........##.........##.......\n" +
            "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..\n" +
            ".#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.\n" +
            "..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#\n" +
            ".#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.\n" +
            "..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....\n" +
            ".#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#\n" +
            ".#........#.#........#.#........#.#........#.#........#.#........#\n" +
            "#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...\n" +
            "#...##....##...##....##...##....##...##....##...##....##...##....#\n" +
            ".#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#";

        String[] lines = input.split("\n");
        NavigationSolution navigationSolution = new NavigationSolution();
        int result = navigationSolution.solution(lines, 11, 66, 3, 1);
        assertEquals(7, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day3input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        NavigationSolution navigationSolution = new NavigationSolution();
        int result = navigationSolution.solution(lines, 323, 31, 3, 1);

        //216
        assertEquals(216, result);
        System.out.println("result = " + result);
    }

    @Test
    public void testForPartTwo() throws IOException {

        String path = "src/test/resources/day3input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        NavigationSolution navigationSolution = new NavigationSolution();
        int resultA = navigationSolution.solution(lines, 323, 31, 1, 1);
        BigInteger bA = BigInteger.valueOf(resultA);

        int resultB = 216;
        BigInteger bB = BigInteger.valueOf(resultB);

        int resultC = navigationSolution.solution(lines, 323, 31, 5, 1);
        BigInteger bC = BigInteger.valueOf(resultC);

        int resultD = navigationSolution.solution(lines, 323, 31, 7, 1);
        BigInteger bD = BigInteger.valueOf(resultD);

        int resultE = navigationSolution.solution(lines, 323, 31, 1, 2);
        BigInteger bE = BigInteger.valueOf(resultE);

        BigInteger result = bA.multiply(bB).multiply(bC).multiply(bD).multiply(bE);

        assertEquals("6708199680", result.toString());
    }
}
