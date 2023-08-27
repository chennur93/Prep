package Leetcode;

import CommonClasses.ListNode;

import java.util.HashMap;

public class cycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<ListNode, Integer> checkMap = new HashMap<>();
        ListNode curr = head;
        while (curr.next != null) {
            if (checkMap.containsKey(curr.next)) {
                return true;
            } else {
                checkMap.put(curr, 0);
                curr = curr.next;
            }
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
