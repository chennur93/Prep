package CompanyInterviewQuestions.Microsoft;

import java.util.Stack;
import CommonClasses.ListNode;


public class AddTwoNumbersII {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    while(l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    };
    while(l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    int sum = 0;
    ListNode node = new ListNode(0);
    while (!s1.empty() || !s2.empty()) {
      if (!s1.empty()) sum += s1.pop();
      if (!s2.empty()) sum += s2.pop();
      node.val = sum % 10;
      ListNode head = new ListNode(sum / 10);
      head.next = node;
      node = head;
      sum /= 10;
    }

    return node.val == 0 ? node.next : node;
  }
}
