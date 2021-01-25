import java.util.*;
import java.io.*;
import java.lang.*;

public class WordBreak {
   public static void main(String[] args) {
      String s = "leetcode";
      List<String> dict = Arrays.asList("leet","code");
      boolean canSplit = solve(s, dict);
      System.out.println(canSplit == true);

      s = "applepenapple";
      dict = Arrays.asList("apple","pen");
      canSplit = solve(s, dict);
      System.out.println(canSplit == true);

      s = "catsandog";
      dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
      canSplit = solve(s, dict);
      System.out.println(canSplit == false);

      s = "cars";
      dict = Arrays.asList("car","ca","rs");
      canSplit = solve(s, dict);
      System.out.println(canSplit == true);

      s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
      dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
      canSplit = solve(s, dict);
      System.out.println(canSplit == false);

      s = "catsandogcat";
      dict = Arrays.asList("cats","dog","sand","and","cat","an");
      canSplit = solve(s, dict);
      System.out.println(canSplit == true);
   }

   public static boolean solve(String string, List<String> wordDict) {
      boolean[][] failures = new boolean[wordDict.size()][string.length()];
      return helper(0, string, wordDict, failures);
   }

   public static boolean helper(int index, String string, List<String> wordDict, boolean[][] failures) {

      if (index == string.length()) {
         return true;
      }

      String thisString = string.substring(index);

      int iWord = 0;
      for (String word : wordDict){
         boolean test1 = iWord < wordDict.size();
         boolean test2 = false;
         if (test1) {
            test2 = !failures[iWord][index];
         }
         boolean test3 = thisString.startsWith(word);
         if (iWord < wordDict.size() && !failures[iWord][index] && thisString.startsWith(word)){
            int wordLength = word.length();
            int newIndex = index + wordLength;
            boolean isSplitRecursive = helper(newIndex, string, wordDict, failures);
            if (isSplitRecursive) {
               return true;
            } else {
               failures[iWord][index] = true;
            }
         }
         iWord++;
      }

      return false;
   } 

}