package realinterviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountingSubAnagramsTest {

    @Test
    void given_containsAnagram_whenStringChallenge_returnsTrue() {
        String str1 = "cdore";
        String str2 = "coder";

        CountingSubAnagrams countingSubAnagrams = new CountingSubAnagrams();
        boolean result = countingSubAnagrams.stringChallenge(str1, str2);

        assertEquals(true, result);
    }

    @Test
    void given_notContainsAnagram_whenStringChallenge_returnsFalse() {
        String str1 = "h3llko";
        String str2 = "hello";

        CountingSubAnagrams countingSubAnagrams = new CountingSubAnagrams();
        boolean result = countingSubAnagrams.stringChallenge(str1, str2);

        assertEquals(false, result);
    }

    @Test
    void given_bothEmpty_whenStringChallenge_returnsTrue() {
        String str1 = "";
        String str2 = "";

        CountingSubAnagrams countingSubAnagrams = new CountingSubAnagrams();
        boolean result = countingSubAnagrams.stringChallenge(str1, str2);

        assertEquals(true, result);
    }

    @Test
    void given_str2Empty_whenStringChallenge_returnsFalse() {
        String str1 = "abc";
        String str2 = "";

        CountingSubAnagrams countingSubAnagrams = new CountingSubAnagrams();
        boolean result = countingSubAnagrams.stringChallenge(str1, str2);

        assertEquals(true, result);
    }
    
}
