package Leetcode;

/*
* Problem 977
* Input: [-4,-1,0,3,10]
* Output: [0,1,9,16,100]
* */

public class SquaresOfASortedArray {
  public static void main(String[] args) {
    int[] A = {-7,-3,2,3,11};
    int[] out = sortedSquares(A);
  }
  public static int[] sortedSquares(int[] A) {
    int left = 0;
    int right = A.length-1;
    int[] sol = new int[A.length];

    for (int i=A.length-1; i>=0; i--){
      if (Math.abs(A[left]) > Math.abs(A[right])){
        sol[i] = A[left]*A[left];
        left++;
      }
      else {
        sol[i] = A[right]*A[right];
        right--;
      }
    }
    return sol;
  }
}