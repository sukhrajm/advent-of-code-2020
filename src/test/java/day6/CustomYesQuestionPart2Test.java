package day6;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class CustomYesQuestionPart2Test {

    @Test
    public void testWithOneLineAndOneUniqueLetterRepeated() {
        String input = "abca";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(1, result);

    }

    @Test
    public void testWithOneLineAndOneUniqueLetterNotRepeated() {
        String input = "xyz";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(3, result);

    }

    @Test
    public void testWithTwoLinesAndOneUniqueLetter() {
        String input = "ab\nac";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(1, result);

    }

    @Test
    public void testWithTwoLinesAndTwoUniqueLetter() {
        String input = "ab\nacb";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(2, result);

    }

    @Test
    public void testWithMultipleLinesAndTwoUniqueLetterAlternating() {
        String input = "tr\nrt\ntr\nrt\tr\rt";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(2, result);

    }

    @Test
    public void testWithMultipleLinesAndTwoUniqueLetterAlternatingMixed() {
        String input = "tr\nrt\ntr\nrtb";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(2, result);

    }

    @Test
    public void testWithMultipleLinesAndOneUniqueLetterPerLine() {
        String input = "a\na\na\na";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(1, result);

    }

    @Test
    public void testWithMultipleLinesAndNoCommonLetters() {
        String input = "a\nb\nc";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(0, result);

    }

    @Test
    public void testWithOneAndOneLetter() {
        String input = "a";
        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();

        long result = customYesQuestionPart2.solution(input);
        assertEquals(1, result);

    }


   /* @Test
    public void testWithMultipleGroups(){
        String input = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b";

        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();
        long result = customYesQuestionPart2.solution(input);
        assertEquals(6, result);
    }*/

    /*@Test
    public void testWithInputFile() throws IOException {

        String path = "src/test/resources/day6input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());


        CustomYesQuestionPart2 customYesQuestionPart2 = new CustomYesQuestionPart2();
        long result = customYesQuestionPart2.solution(contentOfFile);
        System.out.println("result = " + result);
    }*/
}
