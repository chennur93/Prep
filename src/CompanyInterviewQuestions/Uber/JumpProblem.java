package CompanyInterviewQuestions.Uber;

/**
 * Its a one player array game of 'numbers' array. You have to pick an index initially and then jump till the end of the array to make the maximum number of jumps possible.
 * Say you are jumping from i to j then for the jump to be valid the following conditions should be met.
 * 1. j > i + diff, for a given value of diff.
 * 2. number[i] = number[j]
 *
 * Example:
 * 1. numbers[] = {1, 2, 3, 1, 3, 2, 1}; diff = 2 || Solution = 3; Valid jumps: [0, 3, 6]
 * 2. numbers[] = {4, 3, 1, 2, 1, 3, 3, 1, 2, 3}; diff = 1 || Solution = 3; Valid Jumps: [1, 5, 9]
 */


public class JumpProblem {
    public static int getMaxJumps(int[] arr, int diff) {
        int i=0,j=0,k=0,jumps=0,maxJumps=0;
        while (i<arr.length) {
            while (j<arr.length) {
                if ((j > i + diff) && (arr[i] == arr[j])) {
                    i=j;
                    jumps += 1;
                }
                j++;
            }
            maxJumps = Math.max(maxJumps, jumps);
            i=k++;
            j=i+diff+1;
            jumps=0;
        }
        return maxJumps+1;
    }
}
