package amazon.ArrAndString;

import java.util.*;
import java.util.stream.Collectors;

public class TopK {
    public static int[] kFrequent(int[] arr, int k) {
        Arrays.sort(arr);
        PriorityQueue<NumCount> pq = new PriorityQueue<>(k, (o1, o2) -> o2.frequency - o1.frequency);

        int count = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                count++;
                NumCount nq = new NumCount(arr[i-1], count);
                pq.add(nq);
                count = 0;
            } else {
                count++;
            }
        }

        int[] result = new int[k];

        for (int i=0; i< k; i++) {
            result[i] = pq.peek().number;
            pq.remove();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(kFrequent(nums, k)));
    }
}

class NumCount {
    int number;
    int frequency;

    public NumCount(int num, int freq){
        this.number = num;
        this.frequency = freq;
    }
}
