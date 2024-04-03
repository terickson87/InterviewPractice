package realinterviews;

import java.util.Map;
import java.lang.Character;
import java.util.HashMap;
/* 
 * String Challenge
Have the function StringChallenge(str1,str2) take both parameters being passed and return the string true if a portion
of str1 characters can be rearranged to match str2, otherwise return the string false. For example: if str1 is
"rkqodlw" and str2 is "world" the output should return true. Punctuation and symbols will not be entered with the
parameters.

Examples
Input: "cdore" & str2 = "coder"
Output: true
Input: "h3llko" & str2 = "hello"
Output: false

 */

public class CountingSubAnagrams {

    public boolean stringChallenge(String str1, String str2) {
        Map<Character, Integer> str1Map = makeCharCountMap(str1);
        Map<Character, Integer> str2Map = makeCharCountMap(str2);
        boolean out = isMapContainsAtLeastCharacters(str1Map, str2Map);

        return out;
    }

    private Map<Character, Integer> makeCharCountMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char chr : str.toCharArray()) {
            int val = 1;
            if (map.containsKey(chr)) {
                int existingVal = map.get(chr);
                val += existingVal;
            }
            map.put(chr, val);
        }

        return map;
    }

    private boolean isMapContainsAtLeastCharacters(Map<Character, Integer> toCheck, Map<Character, Integer> checkFor) {
        for (Map.Entry<Character, Integer> entry : checkFor.entrySet()) {
            int toCheckVal = toCheck.getOrDefault(entry.getKey(), 0);
            if (toCheckVal < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
}
