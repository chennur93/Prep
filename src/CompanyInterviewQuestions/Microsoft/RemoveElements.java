package CompanyInterviewQuestions.Microsoft;

/**
 * Q: Remove elements from an existing array while preserving it and push the existing elements to the left of the array and add tailing 0s
 *
 * eg: Arr = {1,2,3,1,5}
 * value to be removed = 1
 * Output : {2,3,5,0,0}
 */

public class RemoveElements {
    public static int[] removeElements(int[] A, int k) {
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            if (A[i] == k) {
                while (A[i] == k) {
                    j++;
                }
            }
            A[i] = A[i+j];
        }
        return A;
    }
}
