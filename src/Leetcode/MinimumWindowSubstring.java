package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> testMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++){
            int count = testMap.getOrDefault(t.charAt(i), 0);
            testMap.put(t.charAt(i), count + 1);
        }

        int required = testMap.size();
        int formed = 0;
        int l = 0, r = 0;

        Map<Character, Integer> windowCount =  new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCount.getOrDefault(s.charAt(r), 0);
            windowCount.put(s.charAt(r), count + 1);

            if (testMap.containsKey(c) && windowCount.get(c).intValue() == testMap.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);

                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // element at 'l' is no longer a part of the window.
                windowCount.put(c, windowCount.get(c) - 1);

                if (testMap.containsKey(c) && windowCount.get(c) < testMap.get(c)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
