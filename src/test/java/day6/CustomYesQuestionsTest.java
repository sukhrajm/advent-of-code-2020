package day6;

import day5.BinaryBoarding;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class CustomYesQuestionsTest {

    @Test
    public void testOneGroup() {

        //a string separated by new lines to represent 1 group
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

        CustomYesQuestions customYesQuestions = new CustomYesQuestions();
        long result = customYesQuestions.solution(input);

        assertEquals(11, result);
    }

    @Test
    public void testForFile() throws IOException {
        String path = "src/test/resources/day6input.txt";
        File file = new File(path);

        String contentOfFile = Files.readString(file.toPath());

        CustomYesQuestions customYesQuestions = new CustomYesQuestions();
        long result = customYesQuestions.solution(contentOfFile);

        System.out.println(result);
    }


}