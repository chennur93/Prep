package Leetcode;

import CommonClasses.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static ListNode mergeLists(ListNode[] lists) {
        int k = lists.length;
        ListNode curr, least=lists[0], result = null;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < lists.length; i++) {
            curr = lists[i];
            if (curr.val <= least.val) {
                least = curr;
                if (result == null) {
                    result = least;
                } else {
                    result.next = least;
                }
            }
        }
        return result;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> qu = new PriorityQueue<>((c, d) -> c.val-d.val); // create a min priority queue by comparing the ListNode's value (val)
        // Iterate through the array of lists and push it into the queue
        for(ListNode value:lists){
            while(value!=null){
                qu.add(value); // If value is directly added to queue then there will be cycle in linked list as the node will have next pointed to the the next node
                value = value.next;
            }
        }

        ListNode top = qu.poll(); // Get head of the new linked list to be returned
        ListNode tmp = top;
        // Empty the queue into the new linked list
        while(!qu.isEmpty()){
            tmp.next = qu.poll();
            tmp = tmp.next;
        }

        return top;
    }
}
