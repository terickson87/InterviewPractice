package interviewpractice.lettercombinations;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LetterCombinationsTest {
    @Test
    void example1() {
        String digits = "23";
        List<String> expected = new ArrayList<>(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations(digits);
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void example2() {
        String digits = "";
        List<String> expected = new ArrayList<>();
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations(digits);
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void example3() {
        String digits = "2";
        List<String> expected = new ArrayList<>(Arrays.asList("a","b","c"));
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations(digits);
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }
}
