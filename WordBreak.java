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

      s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
      dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
      canSplit = solve(s, dict);
      System.out.println(canSplit);
   }

   public static boolean solve(String string, List<String> wordDict) {
      HashSet<WordAtIndex> failures = new HashSet<>();
      return helper(0, string, wordDict, failures);
   }

   public static boolean helper(int index, String string, List<String> wordDict, HashSet<WordAtIndex> failures) {

      if (index == string.length()) {
         return true;
      }

      String thisString = string.substring(index);

      for (String word : wordDict){
         WordAtIndex wordAtIndex = new WordAtIndex(word, index);
         if (!failures.contains(wordAtIndex) && thisString.startsWith(word)){
            int wordLength = word.length();
            int newIndex = index + wordLength;
            boolean isSplitRecursive = helper(newIndex, string, wordDict, failures);
            if (isSplitRecursive) {
               return true;
            } else {
               failures.add(wordAtIndex);
            }
         }
      }

      return false;
   } 

}

class WordAtIndex {
   private final String mWord;
   private final int mIndex;

   public WordAtIndex(String word, int index) {
      mWord = word;
      mIndex = index;
   }
}