package Leetcode;

/*
 * Problem 905
 * */

public class SortArrayByParity {
  public int[] sortArrayByParity(int[] A) {
    int even = 0;
    int odd = A.length - 1;
    int[] sol = new int[A.length];


    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 == 0) {
        sol[even] = A[i];
        even++;
      }
      if (A[i] % 2 == 1){
        sol[odd] = A[i];
        odd--;
      }
    }
    return sol;
  }
}
