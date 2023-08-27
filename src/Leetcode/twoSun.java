package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TWO SUM
 * */

public class twoSun {

  public static void main(String[] Args) {
    int[] nums = {3,2,4};
    int target = 6;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }

  public static int[] twoSum(int[] nums, int target) {
    int i,j, val;
    HashMap map = new HashMap<>();

    for (i=0; i<nums.length ;i++) {
      map.put(target-nums[i],i);
    }

    for (j=0; j<nums.length ;j++) {
      if (map.containsKey(nums[j]) && (int) map.get(nums[j]) != j){
        break;
      }
    }

    return new int[]{j, (int) map.get(nums[j])};
  }
}
