package interviewpractice.lettercombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> combinations = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> numberLetterMap = new HashMap<>();
        numberLetterMap.put(2, new ArrayList<String>(Arrays.asList("a","b","c")));
        numberLetterMap.put(3, new ArrayList<String>(Arrays.asList("d","e","f")));
        numberLetterMap.put(4, new ArrayList<String>(Arrays.asList("g","h","i")));
        numberLetterMap.put(5, new ArrayList<String>(Arrays.asList("j","k","l")));
        numberLetterMap.put(6, new ArrayList<String>(Arrays.asList("m","n","o")));
        numberLetterMap.put(7, new ArrayList<String>(Arrays.asList("p","q","r","s")));
        numberLetterMap.put(8, new ArrayList<String>(Arrays.asList("t","u","v")));
        numberLetterMap.put(9, new ArrayList<String>(Arrays.asList("w","x","y","z")));

        backtrack("", digits, numberLetterMap, combinations);
            
        return combinations;
    }

    private void backtrack(String combo, String digits, HashMap<Integer, ArrayList<String>> numberLetterMap, List<String> combinations) {
        if (digits.isEmpty()) {
            combinations.add(combo);
        } else {
            int digit = Character.getNumericValue(digits.charAt(0));
            ArrayList<String> letterList = numberLetterMap.get(digit);
            for (String letter : letterList) {
                backtrack(combo + letter, digits.substring(1), numberLetterMap, combinations);
            }
        }
    }
}
