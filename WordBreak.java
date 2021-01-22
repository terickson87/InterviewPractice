import java.util.*;
import java.io.*;
import java.lang.*;

public class WordBreak {
   public static void main(String[] args) {
      String s = "leetcode";
      List<String> dict = Arrays.asList("leet","code");
      System.out.println(solve(s, dict));

      s = "applepenapple";
      dict = Arrays.asList("apple","pen");
      System.out.println(solve(s, dict));

      s = "catsandog";
      dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
      System.out.println(solve(s, dict));

      s = "cars";
      dict = Arrays.asList("car","ca","rs");
      System.out.println(solve(s, dict));
   }

   public static boolean solve_bfs() {
      return false;
   }
   
   public static boolean solve(String string, List<String> wordDict) {
      Set<Integer> memo_fail = new HashSet<>();
      return helper(0, memo_fail, string, wordDict);
   }

   public static boolean helper(int index, Set<Integer> memo_fail, String string, List<String> wordDict) {
      if (index == string.length()) {
         return true;
      }

      if (memo_fail.contains(index)) {
         return false;
      }

      return false;
   } 

}