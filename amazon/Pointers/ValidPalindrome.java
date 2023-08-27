package amazon.Pointers;

public class ValidPalindrome {
    public static boolean isValid(String phrase) {
        String str = phrase.toLowerCase();
        int len = str.length();
        int left = 0, right = len - 1;

        while (left < right) {
            char first = str.charAt(left);
            char last = str.charAt(right);
            if (Character.isLetterOrDigit(first)) {
                if (Character.isLetterOrDigit(last)) {
                    if (first == last) {
                        left++;
                        right--;
                    } else {
                        return false;
                    }
                } else
                    right--;
            } else
                left++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("A man, a plan, a canal: Panama"));
        System.out.println(isValid("race a car"));
        System.out.println(isValid(" "));
    }
}
