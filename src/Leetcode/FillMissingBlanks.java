package Leetcode;

public class FillMissingBlanks {
    public static int numWaysSplitParen(String paren) {
        char[] chars = paren.toCharArray();
        int count = 0;

        for (int i=1; i<=chars.length-1; i++) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int j=0; j<i; j++) {
                left.append(chars[j]);
            }

            for (int k=i; k<chars.length; k++) {
                right.append(chars[k]);
            }

            if (isBalanced(left.toString()) && isBalanced(right.toString())) count++;
        }

        return count;
    }

    public static boolean isBalanced(String str) {
        System.out.println("This is the string: " + str);
        int parenLeftCount = 0;
        int bracketLeftCount = 0;
        int wildcard = 0;

        for (char c : str.toCharArray()) {

            if (c == '(') parenLeftCount++;
            if (c == ')') parenLeftCount--;
            if (c == '[') bracketLeftCount++;
            if (c == ']') bracketLeftCount--;
            if (c == '?') wildcard++;
        }

        if (parenLeftCount + bracketLeftCount + wildcard == 0 || parenLeftCount + bracketLeftCount - wildcard == 0 || (wildcard % 2 == 0 && wildcard != 0)) return true;
        return false;
    }

    public static int numWaysSplitParen2(String paren) {
        int count = 0;
        if (paren.length() % 2 == 0) {
            char[] chars = paren.toCharArray();
            for (int i=2; i<=chars.length-1; i = i + 2) {
                    if (isBalanced1(paren, 0, i) && isBalanced1(paren, i, paren.length())) count ++;
            }
        }

        return count;
    }

    public static boolean isBalanced1(String str, int startIndex, int endIndex) {
//        System.out.println("This is the string: " + str);
        int parenLeftCount = 0;
        int bracketLeftCount = 0;
        int wildcard = 0;

        for (int i = startIndex; i < endIndex; i++) {
            char c = str.charAt(i);
            if (c == '(') parenLeftCount++;
            else if (c == ')') parenLeftCount--;
            else if (c == '[') bracketLeftCount++;
            else if (c == ']') bracketLeftCount--;
            else if (c == '?') wildcard++;
        }

        return parenLeftCount + bracketLeftCount + wildcard == 0 || parenLeftCount + bracketLeftCount - wildcard == 0 || (wildcard == endIndex-startIndex);
    }
}
