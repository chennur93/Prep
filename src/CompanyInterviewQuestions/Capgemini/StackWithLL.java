package CompanyInterviewQuestions.Capgemini;

import CommonClasses.ListNode;

public class StackWithLL {
    ListNode top;

    public StackWithLL() {
        this.top = null;
    }

    public void push(int data) {
        if (top == null) {
            top = new ListNode(data);
        }
        ListNode curr = new ListNode(data);
        curr.next = top;
        top = curr;
    }

    public int pop() {
        if (!isEmpty()) {
            ListNode curr = top;
            top = top.next;
            return curr.val;
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    public int peak() {
        if (!isEmpty()) {
            return top.val;
        } else {
            System.out.println("Stack is Empty");
            return(-1);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (!isEmpty()) {
            ListNode curr = top;
            while (curr.next != null) {
                System.out.println(curr.val);
                curr = curr.next;
            }
        } else {
            System.out.println("Stack Underflow");
        }
    }
}
