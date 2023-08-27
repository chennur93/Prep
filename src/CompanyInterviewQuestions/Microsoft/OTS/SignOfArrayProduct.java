package CompanyInterviewQuestions.Microsoft.OTS;

public class SignOfArrayProduct {
    public int solution(int[] A) {
        int negativesCount = 0;
        for (int a : A) {
            if (a == 0)
                return 0;
            if (a < 0)
                negativesCount++;
        }
        return negativesCount % 2 == 0 ? 1 : -1;
    }
}
