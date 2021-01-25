import java.util.*;
import java.io.*;
import java.lang.*;

public class WordBreak {
   public static void main(String[] args) {
      String s = "leetcode";
      List<String> dict = Arrays.asList("leet","code");
      boolean canSplit = solve(s, dict);
      System.out.println(canSplit);

      s = "applepenapple";
      dict = Arrays.asList("apple","pen");
      canSplit = solve(s, dict);
      System.out.println(canSplit);

      s = "catsandog";
      dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
      canSplit = solve(s, dict);
      System.out.println(canSplit);

      s = "cars";
      dict = Arrays.asList("car","ca","rs");
      canSplit = solve(s, dict);
      System.out.println(canSplit);
   }
   
   public static boolean solve(String string, List<String> wordDict) {
      return helper(0, string, wordDict);
   }

   public static boolean helper(int index, String string, List<String> wordDict) {

      if (index == string.length()) {
         return true;
      }

      String thisString = string.substring(index);

      for (String word : wordDict){
         if (thisString.startsWith(word)){
            int wordLength = word.length();
            int newIndex = index + wordLength;
            boolean recursive = helper(newIndex, string, wordDict);
            if (recursive) {
               return true;
            }
         }
      }

      return false;
   } 

}