package Leetcode;

import CommonClasses.ListNode;

import java.util.*;

public class ReverseALinkedList {

    public static ListNode reverseList(ListNode head) {
        Deque<Integer> temp = new ArrayDeque<>();

        while (head != null) {
            temp.push(head.val);
            head = head.next;
        }

        ListNode solHead = null, curr = null;
        while (!temp.isEmpty()) {
            if (solHead == null) {
                solHead = new ListNode(temp.pop());
                curr = solHead;
            } else {
              curr.next = new ListNode(temp.pop());
              curr = curr.next;
            }
        }
        return solHead;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null || curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        // After the last element is returned in the last iteration head.next is the last element and setting head.next.next would
        // start the creation on the LinkedList in reverse.
        head.next.next = head;
        head.next = null;
        return p;
    }
}