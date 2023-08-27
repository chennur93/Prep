package amazon.ArrAndString;

import java.util.Arrays;

public class ProductExceptItself {
    public static int[] solution(int[] arr) {
        int[] sol = new int[arr.length];
        int[] left = new int[arr.length];
        Arrays.fill(left, 1);
        int[] right = new int[arr.length];
        Arrays.fill(right, 1);

        for (int i=1; i<left.length; i++) {
            left[i] = arr[i-1] * left[i-1];
        }

        for (int i=right.length-2; i>= 0; i--) {
            right[i] = right[i+1] * arr[i+1];
        }

        for (int i=0; i<sol.length; i++) {
            sol[i] = left[i] * right[i];
        }

        return sol;
    }

    public static void main(String[] args) {
        int[] test = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(solution(test)));
    }
}
