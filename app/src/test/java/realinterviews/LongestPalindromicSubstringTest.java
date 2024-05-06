package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstringTest {

    private static String challengeTokenReversed = new StringBuffer("ChallengeToken").reverse().toString();

    @Test 
    void given_test1_when_SearchingChallenge_then_success() {
        // Arrange
        String input = "hellosannasmith";

        // Act
        String result = LongestPalindromicSubstring.SearchingChallenge(input);

        // Assert
        String output = "sannas";
        String outputRevserved = new StringBuffer(output).reverse().toString();
        String expected = outputRevserved + ":" + challengeTokenReversed;
        assertEquals(expected, result);
    }

    @Test 
    void given_test2_when_SearchingChallenge_then_success() {
        // Arrange
        String input = "abcdefgg";

        // Act
        String result = LongestPalindromicSubstring.SearchingChallenge(input);

        // Assert
        String output = "none";
        String outputRevserved = new StringBuffer(output).reverse().toString();
        String expected = outputRevserved + ":"  + challengeTokenReversed;
        assertEquals(expected, result);
    }
}
