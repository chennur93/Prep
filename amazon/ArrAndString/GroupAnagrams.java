package amazon.ArrAndString;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        List<List<String>> anagramGroups = new ArrayList<>();
        int nextStart = 0;


        for (int i=0; i<strs.length; i++) {
            List<String> strList = new ArrayList<>();
            if (strs[i] != null)
                strList.add(strs[i]);
            else
                continue;

            for (int j=i+1; j<strs.length; j++) {
                if (strs[j] != null && strs[i] != null && isAnagram(strs[i], strs[j])) {
                    strList.add(strs[j]);
                    strs[j] = null;
                }
            }
            strs[i] = null;
            anagramGroups.add(strList);
        }
        return anagramGroups;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] charArr = new int[26];

        for (char c : s.toCharArray())
            charArr[c - 'a']++;

        for (char c : t.toCharArray()) {
            if (charArr[c - 'a'] > 0)
                charArr[c - 'a']--;
        }
        return Arrays.stream(charArr).sum() == 0;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            s = s.toLowerCase();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (anagramMap.containsKey(sorted))
                anagramMap.get(sorted).add(s);
            else {
                List<String> res = new ArrayList<>();
                res.add(s);
                anagramMap.put(sorted, res);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> ls: anagramMap.values()) {
            result.add(ls);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strArr = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> res = groupAnagrams2(strArr);

        System.out.println(res);
    }
}
