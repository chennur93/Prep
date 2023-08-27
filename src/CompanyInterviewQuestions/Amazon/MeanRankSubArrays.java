package CompanyInterviewQuestions.Amazon;

public class MeanRankSubArrays {
    public static int[] solution(int[] ranks) {
        int n = ranks.length;
        int[] prefixSum = new int[n];
        int[] count = new int[n];
        int[] results = new int[n];

        prefixSum[0] = ranks[0];
        count[ranks[0] - 1] = 1;
        results[ranks[0] - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + ranks[i];
            count[ranks[i] - 1]++;
            results[prefixSum[i] - 1] = i + 1;
        }

        for (int x = 1; x <= n; x++) {
            results[x - 1] = results[x - 1] + count[x - 1];
        }

        return results;
    }

    public static void main(String[] args){
        int[] ranks = {1, 2, 3, 4, 5};
        int[] results = solution(ranks);

        for (int x = 1; x <= ranks.length; x++) {
            System.out.println("Mean rank " + x + ": " + results[x - 1]);
        }
    }
}
