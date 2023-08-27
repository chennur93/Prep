package Leetcode;

import CommonClasses.ListNode;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
      return null;
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    ListNode head = null, curr = null;

    while (l1.next != null && l2.next != null) {
      if (l1.val >= l2.val) {
        if (head == null) {
          head = new ListNode(l2.val);
          curr = head;
          l2 = l2.next;
        }else {
          curr.next = new ListNode(l2.val);
          curr = curr.next;
          l2 = l2.next;
        }
      }else {
        if (head == null) {
          head = new ListNode(l1.val);
          curr = head;
          l1 = l1.next;
        }else {
          curr.next = new ListNode(l1.val);
          curr = curr.next;
          l1 = l1.next;
        }
      }
    }

    return head;
  }
}
