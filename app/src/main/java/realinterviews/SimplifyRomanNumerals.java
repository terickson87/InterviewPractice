package realinterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.Scanner;

/* 
Have the function StringChallenge(str) read str which will be a string of roman numerals in decreasing order. The numerals being used are: I for 1, V for 5, X for 10, L for 50, C for 100, D for 500 and M for 1000. Your program should return the same number given by str using a smaller set of roman numerals. For example: if str is "LLLXXXVVVV" this is 200, so your program should return CC because this is the shortest way to write 200 using the roman numeral system given above. If a string is given in its shortest form, just return that same string.
Once your function is working, take the final output string and combine it with your ChallengeToken, both in reverse order and separated by a colon.

Your ChallengeToken: challengeToken
 */

public class SimplifyRomanNumerals {
    private static Map<Character, Integer> numeralValues;
    private static Map<Integer, Character> valueNumerals;
    private static List<Integer> sortedValueList;
    private static String challengeToken = "ChallengeToken";

    static {
        numeralValues = new HashMap<>();
        numeralValues.put('I', 1);
        numeralValues.put('V', 5);
        numeralValues.put('X', 10);
        numeralValues.put('L', 50);
        numeralValues.put('C', 100);
        numeralValues.put('D', 500);
        numeralValues.put('M', 1000);

        valueNumerals = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : numeralValues.entrySet()) {
            valueNumerals.put(entry.getValue(), entry.getKey());
        }

        sortedValueList = new ArrayList<Integer>(numeralValues.values());
        Collections.sort(sortedValueList);
        Collections.reverse(sortedValueList);
    }

    public static String StringChallenge(String str) {
        int value = numeralsToValue(str);
        // System.out.println(value);
        String outStr = valueToNumerals(value);
        // Need to reverse b/c the valueToNumerals iteration runs in the opposite order
        String outStrRev = new StringBuffer(outStr).reverse().toString();
        String outStrWithToken = outStrRev + ":" + new StringBuffer(challengeToken).reverse();
        return outStrWithToken;
    }

    public static int numeralsToValue(String str) {
        int value = 0;
        for (char c : str.toCharArray()) {
          value += numeralValues.get(c);
        }
        return value;
    }

    public static String valueToNumerals(int value) {
        StringBuilder sb = new StringBuilder();
    
        while (value > 0) { // This while loop may not be needed
            for (int val : sortedValueList) {
                // System.out.println("val: " + val);
                int div = value / val;
                // System.out.println("div: " + div);
                if (div > 0) {
                    value -= div*val;
                    // System.out.println("new value: " + value);
                    sb.append(valueNumerals.get(val).toString().repeat(div));
                }
            }
        }
    
        return sb.toString();
    }

    // public static void main (String[] args) {  
    //     // keep this function call here     
    //     Scanner s = new Scanner(System.in);
    //     System.out.print(StringChallenge(s.nextLine())); 
    // }

}
