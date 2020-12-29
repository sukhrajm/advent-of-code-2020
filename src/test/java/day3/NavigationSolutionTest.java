package day3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
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
        int result = navigationSolution.solution(lines, 11, 66);
        assertEquals(7, result);
    }

    @Test
    public void testWithFile() throws IOException {
        String path = "src/test/resources/day3input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        String[] lines = contentOfFile.split("\n");

        NavigationSolution navigationSolution = new NavigationSolution();
        int result = navigationSolution.solution(lines, 323, 31);

        //216
        assertEquals(216, result);
        System.out.println("result = " + result);
    }
}
