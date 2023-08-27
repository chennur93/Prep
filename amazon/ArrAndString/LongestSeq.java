package amazon.ArrAndString;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestSeq {
    public static int longestConsecutiveSequence(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Queue<Integer> pq = new PriorityQueue<>(nums.length, Comparator.comparingInt(num -> num));

        for (int i : nums) {
            pq.add(i);
        }

        int longestSeq = 0;
        int last=Integer.MIN_VALUE, count=0;

        while(!pq.isEmpty()) {
            if (pq.peek() == last+1)
                count++;
            else if (pq.peek() == last) {
            }
            else {
                count = 1;
            }
            last = pq.poll();
            longestSeq = Math.max(longestSeq, count);
        }
        return longestSeq;
    }

    public static int longestSeq(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
    private static boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int[] arr1 = {100,4,200,1,3,2};
        int[] arr2 = {0,-1};
        int[] arr3 = {1,2,0,1};
        System.out.println(longestConsecutiveSequence(arr));
        System.out.println(longestConsecutiveSequence(arr1));
        System.out.println(longestConsecutiveSequence(arr2));
        System.out.println(longestConsecutiveSequence(arr3));
        System.out.println(longestSeq(arr));
        System.out.println(longestSeq(arr1));
        System.out.println(longestSeq(arr2));
        System.out.println(longestSeq(arr3));
    }
}
