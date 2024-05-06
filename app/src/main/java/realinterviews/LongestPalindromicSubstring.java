package realinterviews;

/* 
 Have the function SearchingChallenge(str) take the str parameter being passed and find the longest palindromic substring, which means the longest substring which is read the same forwards as it is backwards. For example: if str is "abracecars" then your program should return the string racecar because it is the longest palindrome within the input string.

The input will only contain lowercase alphabetic characters. The longest palindromic substring will always be unique, but if there is none that is longer than 2 characters, return the string none.
Once your function is working, take the final output string and combine it with your ChallengeToken, both in reverse order and separated by a colon.

Your ChallengeToken: ChallengeToken
 */

public class LongestPalindromicSubstring {
  private static String challengeToken = "ChallengeToken";

  public static String SearchingChallenge(String str) {
    String longest = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.length() - i > 2) {
        for (int j = str.length(); j > i + 1; j--) {
          String toTest = str.substring(i,j);
          String rev = new StringBuffer(toTest).reverse().toString();
          if (toTest.equals(rev) && toTest.length() > longest.length()) {
            longest = toTest;
          }
        }
      }
    }
    String out = longest.equals("") ? "none" : longest;
    return new StringBuffer(out).reverse() + ":" + new StringBuffer(challengeToken).reverse();
  }

//   public static void main (String[] args) {  
//     // keep this function call here     
//     Scanner s = new Scanner(System.in);
//     System.out.print(SearchingChallenge(s.nextLine())); 
//   }
}
