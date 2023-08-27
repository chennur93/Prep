package Leetcode;

import java.util.HashMap;

public class LengthofLongestSubstring {
    public static int lengthOfSubstring(String s) {
        int len = s.length();
        int left=0,right=0;
        int maxlength=0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<len; i++) {
            if (map.containsKey(s.charAt(i)) && (map.get(s.charAt(i)) >= left)) {
                    left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            right++;
            maxlength = Math.max(right - left, maxlength);
        }
        return maxlength;
    }
}
