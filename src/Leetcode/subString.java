package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring without repeating characters.
 * */

public class subString {

  public static void main(String[] args) {
    String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    int i=0, j=0, ans=0;
    int n = s.length();
    Set<Character> set = new HashSet<>();

    while (i<n && j<n) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j-i);
      }else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
}
