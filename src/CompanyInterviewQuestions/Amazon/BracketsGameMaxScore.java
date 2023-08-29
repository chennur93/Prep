package CompanyInterviewQuestions.Amazon;

/**
 * Amazon Games has recently launched a bracket matching pair game for kids. In this game, a bracket sequence in the form of a string, s of length n is given. The string only contains the characters '(' and ').
 * In one move, choose two characters, at positions i and j such that 0 si < j<nand s[i] = '(
 * and slil = 'Y and (j - i) points are added to the score. If some index x is chosen before, it
 * can not be chosen again.
 * Determine the maximum possible score.
 *
 * Example:
 * If s= "()()"
 * • We can use 2 moves (¡=0, j=1 and i=2, j=3) to get (1-0) + (3-2) = 2 score.
 * • Another sequence of moves could be if we use just one move (¡=0, j=3) and get (3-0) = 3.
 * There is no way to score more than 3, so return 3.
 */

public class BracketsGameMaxScore {
    public static long maxScore(String s) {

        if (s.length() <= 1)
            return 0;

        int i = 0, j = s.length() - 1;
        long maxScore = 0;
        long score = 0;

        while (i < j) {

            while (i < j && s.charAt(i) != '(')
                i++;

            while (i < j && s.charAt(j) != ')')
                j--;

            score += j - i;
            i++;
            j--;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("(()")); // result 2
        System.out.println(maxScore("(())")); // result 4
    }
}
