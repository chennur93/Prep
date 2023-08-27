package amazon.Pointers;

import java.util.Arrays;

public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int first=0, last=numbers.length-1;

        while (first < last) {
            if (numbers[first] + numbers[last] > target)
                last--;
            if (numbers[first] + numbers[last] < target)
                first++;
            if (numbers[first] + numbers[last] == target)
                return new int[]{first+1, last+1};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
    }
}
