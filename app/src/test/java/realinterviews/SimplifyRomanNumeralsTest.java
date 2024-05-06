package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimplifyRomanNumeralsTest {

    private static String challengeTokenReversed = new StringBuffer("ChallengeToken").reverse().toString();

    @Test 
    void given_test1_when_StringChallenge_then_success() {
        // Arrange
        String input = "XXXVVIIIIIIIIII";

        // Act
        String result = SimplifyRomanNumerals.StringChallenge(input);

        // Assert
        String output = "L";
        String outputRevserved = new StringBuffer(output).reverse().toString();
        String expected = outputRevserved + ":" + challengeTokenReversed;
        assertEquals(expected, result);
    }

    @Test 
    void given_test2_when_StringChallenge_then_success() {
        // Arrange
        String input = "DDLL";

        // Act
        String result = SimplifyRomanNumerals.StringChallenge(input);

        // Assert
        String output = "MC";
        String outputRevserved = new StringBuffer(output).reverse().toString();
        String expected = outputRevserved + ":"  + challengeTokenReversed;
        assertEquals(expected, result);
    }
}
