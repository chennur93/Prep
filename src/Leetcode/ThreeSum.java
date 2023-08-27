package Leetcode;

import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    int nums[] = {-1, 0, 1, 2, -1, -4};

    System.out.println(getThreeSum(nums));
  }


  public static void getNewThreeSum(int[] nums) {
    HashSet<int[]> outputList = new HashSet<>();
    int first=0,second=1,third=nums.length-1;

    Arrays.sort(nums);


  }

  public static List<List<Integer>> getThreeSum(int[] arr) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> output;
    HashMap<Integer, Integer> map = new HashMap<>();

    if (arr.length < 3)
      return null;

    for (int i=0; i<arr.length; i++) {
      output = helperTwoSum(arr, -arr[i], i, map);
      if (output.size() != 0 && !list.contains(output))
        list.add(output);
    }
    return list;
  }

  public static List<Integer> helperTwoSum(int[] arr, int target, int targetIndex, HashMap<Integer, Integer> map) {

    List<Integer> list = new ArrayList<>();

    if (map.isEmpty()) {
      for (int i = targetIndex + 1; i < arr.length; i++) {
        map.put(target - arr[i], i);
      }
    }

    for (int i=targetIndex+1; i<arr.length; i++) {
      if (map.containsKey(arr[i]) && (map.get(arr[i]) != i)) {
        list.add(arr[targetIndex]);
        list.add(arr[i]);
        list.add(arr[map.get(arr[i])]);
        map.remove(arr[map.get(arr[i])]);
        map.remove(arr[i]);
        break;
      }
    }
    return list;
  }
}
