package amazon.ArrAndString;

import java.util.Arrays;

public class CheckAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] arr =  new int[256];

        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i)] += 1;
        }

        for (int j=0; j<t.length(); j++) {
            if (arr[t.charAt(j)] > 0)
                arr[t.charAt(j)]--;
        }

        return Arrays.stream(arr).sum() == 0;
    }

    public static boolean isAnagram2(String s, String t) {
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

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram2("rat", "car"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
}
