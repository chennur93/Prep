package CompanyInterviewQuestions.Amazon;

import java.util.Arrays;

public class PasswordSimilarity {
    public static String[] solution(String[] oldPasswords, String[] newPasswords) {
        int n = newPasswords.length;
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {
            results[i] = isSimilar(newPasswords[i], oldPasswords[i]) ? "YES" : "NO";
        }

        return results;
    }

    public static boolean isSimilar(String newPassword, String oldPassword) {
        int newIndex = 0;

        for (char oldChar : oldPassword.toCharArray()) {
            while (newIndex < newPassword.length() && newPassword.charAt(newIndex) != oldChar && incrementChar(newPassword.charAt(newIndex)) != oldChar) {
                newIndex++;
            }

            if (newIndex >= newPassword.length()) {
                return false;
            }

            newIndex++;
        }

        return true;
    }

    public static char incrementChar(char c) {
        if (c == 'z') {
            return 'a';
        } else if (c == 'Z') {
            return 'A';
        } else {
            return (char) (c + 1);
        }
    }

    public static void main(String[] args){
        String[] result = solution(new String[]{
                "abdbc", "ach", "abb"}, new String[]{"baacbab", "accdb", "baacha"});

    System.out.println(Arrays.toString(result));
  }
}
