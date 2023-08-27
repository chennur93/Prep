package amazon.ArrAndString;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left=0, right=0;
        int maxLength=0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            if (charMap.containsKey(s.charAt(i)) && (charMap.get(s.charAt(i)) >= left)) {
                left = charMap.get(s.charAt(i)) + 1;
            }
            charMap.put(s.charAt(i), i);
            right++;
            maxLength = Math.max(right - left, maxLength);
        }
        return maxLength;
    }
}
